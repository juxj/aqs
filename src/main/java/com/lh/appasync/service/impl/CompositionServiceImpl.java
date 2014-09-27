package com.lh.appasync.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lh.appasync.dao.ICompositionDAO;
import com.lh.appasync.model.po.Comment;
import com.lh.appasync.model.po.Composition;
import com.lh.appasync.service.ICompositionService;
import com.lh.appasync.service.IPlayerService;
import com.lh.appasync.util.SQLUtils;
import com.lh.util.Constants;
import com.lh.util.EnumUtils;
import com.lh.util.EnumUtils.CommodityHistoryType;
import com.lh.util.EnumUtils.TrendsType;
import com.lh.util.StringUtils;
import com.lh.util.redis.IRedisClient;

public class CompositionServiceImpl implements ICompositionService {

	@Autowired
    private ICompositionDAO compositionDAO;
    
    @Autowired
    private IPlayerService playerService;
    
    @Autowired
    private IRedisClient redisClientComment;

    public void setRedisClientComment(IRedisClient redisClientComment) {
		this.redisClientComment = redisClientComment;
	}
    
    public void setCompositionDAO(ICompositionDAO compositionDAO) {
		this.compositionDAO = compositionDAO;
	}
    
    public void setPlayerService(IPlayerService playerService) {
		this.playerService = playerService;
	}
    
    @Override
    public void updateCommentCount(Map<String, String> parmMap) {
    	
        String queryName = null;
        List<Short> list = new ArrayList<Short>();
        CommodityHistoryType commodityHistoryType = CommodityHistoryType.getCommodityHistoryType(Short.parseShort(parmMap.get("type")));
		switch (commodityHistoryType) {
			case PLAYER:
				break;
			case COMPOSITION:
				if ("0".equals(parmMap.get("mediaType"))) {
					list.add(TrendsType.COMPOSITIONSHARE.getType());
					list.add(TrendsType.COMPOSITIONUPLOAD.getType());
					queryName = SQLUtils.COMPOSITION_UPDATECOMMENTCOUNT;
				} else if ("1".equals(parmMap.get("mediaType"))) {
					list.add(TrendsType.MVCOMPOSITIONSHARE.getType());
					list.add(TrendsType.MVCOMPOSITIONUPLOAD.getType());
					queryName = SQLUtils.COMPOSITION_UPDATECOMMENTCOUNT;
				}
				break;
			case PHOTO:
				list.add(TrendsType.PHOTOSHARE.getType());
				list.add(TrendsType.PHOTOUPLOAD.getType());
				queryName = SQLUtils.PLAYERPHOTO_UPDATECOMMENTCOUNT;
				break;
		}
		
		// 更新评论数
		if(StringUtils.isNotBlank(queryName) && !list.isEmpty()){
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("uid", parmMap.get("uid"));
			param.put("type", list);
			param.put("num", 1);
			compositionDAO.updateCommentCount(queryName, param);
		}
		
		if (null != parmMap.get("uid") && parmMap.get("uid").trim().length() > 0) {
			this.delRedisComposition(parmMap.get("uid"));
			playerService.delRedisPlayer(parmMap.get("playId"));
		}
		
		// 升级
		playerService.updatePlayerExperience2(parmMap.get("playId"),EnumUtils.GradeLevelSetting.FROM_COMMENT.getType(),1);
		playerService.updatePlayerExperience2(parmMap.get("toPlayerId"),EnumUtils.GradeLevelSetting.TO_COMMENT.getType(),1);
    }
    
    @Override
    public void delRedisComposition(String compositionId) {
    	Composition c = compositionDAO.get(compositionId);
		if (c != null) {
			redisClientComment.del(Constants.ConstRedis.R_COMPOSITIONS_MESSAGE_PREFIX + compositionId);// 作品信息列表
			redisClientComment.del(Constants.ConstRedis.R_COMPOSITIONS_COMMENT_PREFIX + compositionId);// 作品评论列表
			redisClientComment.del(Constants.ConstRedis.R_COMPOSITIONS_GIFT_PREFIX + compositionId);// 礼物列表
			playerService.delRedisPlayer(c.getPlayerId());
		}
    	
    }
	
}
