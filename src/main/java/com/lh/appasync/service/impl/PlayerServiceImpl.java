package com.lh.appasync.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.reflect.TypeToken;
import com.lh.appasync.dao.IGradeLevelSettingDAO;
import com.lh.appasync.dao.IPlayerDAO;
import com.lh.appasync.dao.IPlayerGradeInfoDAO;
import com.lh.appasync.model.po.GradeLevelSetting;
import com.lh.appasync.model.po.Player;
import com.lh.appasync.model.po.PlayerGradeInfo;
import com.lh.appasync.service.IPlayerService;
import com.lh.util.Constants;
import com.lh.util.JsonUtil;
import com.lh.util.redis.IRedisClient;

public class PlayerServiceImpl implements IPlayerService {
	
	@Autowired
	private IPlayerDAO playerDAO;
	@Autowired
	private IGradeLevelSettingDAO gradeLevelSettingDAO;
    @Autowired
    private IRedisClient redisClientComment;
    @Autowired
    private IPlayerGradeInfoDAO playerGradeInfoDAO;
    
    public void setPlayerGradeInfoDAO(IPlayerGradeInfoDAO playerGradeInfoDAO) {
		this.playerGradeInfoDAO = playerGradeInfoDAO;
	}
    
    public void setRedisClientComment(IRedisClient redisClientComment) {
		this.redisClientComment = redisClientComment;
	}

    public void setGradeLevelSettingDAO(
			IGradeLevelSettingDAO gradeLevelSettingDAO) {
		this.gradeLevelSettingDAO = gradeLevelSettingDAO;
	}
	
	public void setPlayerDAO(IPlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}
	
	/**
	 * 玩家获取经验
	 */
	public void updatePlayerExperience2(String playerId, Integer type, Integer num) {
		
		Player p = playerDAO.get(playerId);
		if (num == null) {
			num = 0;
		}
		if (p != null && null != type) {
			GradeLevelSetting gs = this.getGradeLevelSetting(type);
			String redisUid = Constants.ConstRedis.R_PLAYER_EXP_ + type + "_"
					+ p.getUid();
			String gsStr = redisClientComment.get(redisUid);
			int count = 0;
			// 判断有没有获取过，并设置过期时间
			if (null != gsStr) {
				count = Integer.parseInt(gsStr);
			} else {
				redisClientComment.set(redisUid, 0 + "");
				redisClientComment.setExpired(redisUid, Constants.ConstRedis.exp_expired_time);
			}
			if (count <= gs.getDayMax() || gs.getDayMax() == -1) {
				if (type == 8) {
					int gift = num / gs.getRequirement();
					if (p.getExperience() == null) {
						p.setExperience(0.00 + gs.getExp() * gift);
					} else {
						p.setExperience(p.getExperience() + gs.getExp() * gift);
					}
					playerDAO.updateObject(p);
					int t = p.getExperience().intValue();
					this.updatePlayerGrade(t, null, playerId);
					redisClientComment.set(redisUid, (count + 1) + "");
				} else {
					if (p.getExperience() == null) {
						p.setExperience(0.00 + gs.getExp() * num);
					} else {
						p.setExperience(p.getExperience() + gs.getExp() * num);
					}
					playerDAO.updateObject(p);
					int t = p.getExperience().intValue();
					this.updatePlayerGrade(t, null, playerId);
					redisClientComment.set(redisUid, (count + 1) + "");
				}
			}
		}
	}
		
	public GradeLevelSetting getGradeLevelSetting(Integer type) {
		String gradeLevelSetting = redisClientComment.get("GradeLevelSetting");
		gradeLevelSetting = null;
		if (null == gradeLevelSetting) {
			List<GradeLevelSetting> list = gradeLevelSettingDAO.findAll();
			String str = JsonUtil.objectToJson(list);
			redisClientComment.set("GradeLevelSetting", str);
			gradeLevelSetting = str;
		}

		Type typeClass = new TypeToken<List<GradeLevelSetting>>() {}.getType();
		List<GradeLevelSetting> setList = (List) JsonUtil.formJsonToObject(gradeLevelSetting, typeClass);
		for (GradeLevelSetting gs : setList) {
			if (gs.getType() == type) {
				return gs;
			}
		}
		return null;
	}
	

	public Integer updatePlayerGrade(Integer songerPopular, Double wealthPopular, String uid) {
		Player player = playerDAO.get(uid);
		int status = 0;// 0：玩家不存在;1:歌手等级更新成功;2:财富等级更新成功
		if (player != null) {
			if (null != songerPopular) {
				PlayerGradeInfo entity = playerGradeInfoDAO.findGradeBySonger(songerPopular);
				if (null != entity) {
					int goodNum=entity.getGradeNum();
					player.setSongerGrade(entity.getGradeName());
					player.setSonger(entity.getGradeNum());
					player.setSongerLogo(entity.getGradeLogo());
					String[][] str2 = new String[][] { { "gradeNum", "=", (goodNum+1)+"" },{ "gradeType", "=", "0" } };
					List<PlayerGradeInfo> list =(List)playerGradeInfoDAO.findparams(null, PlayerGradeInfo.class, str2);
					if(null!=list&&list.size()>0){
						player.setNextSongerGrade(list.get(0).getGradeRules().intValue()-songerPopular);
						player.setSongerGradeTotal(list.get(0).getGradeRules());
					}else{
						player.setNextSongerGrade(0);
					}
					playerDAO.updateObject(player);
					updatePlayerHonorGrade(player.getUid());
					status = 1;
				}

			}

			if (null != wealthPopular) {
				PlayerGradeInfo entity = playerGradeInfoDAO.findGradeByWealth(wealthPopular);
				if (null != entity) {
					int goodNum=entity.getGradeNum();
					player.setWealthGrade(entity.getGradeName());
					player.setWealth(entity.getGradeNum());
					player.setWealthLogo(entity.getGradeLogo());
					String[][] str2 = new String[][] { { "gradeNum", "=", (goodNum+1)+"" },{ "gradeType", "=", "1" } };
					List<PlayerGradeInfo> list =(List)playerGradeInfoDAO.findparams(null, PlayerGradeInfo.class, str2);
					if(null!=list&&list.size()>0){
						player.setNextWealthGrade(list.get(0).getGradeRules().intValue()-wealthPopular.intValue());
						player.setWealthGradeTotal(list.get(0).getGradeRules());
					}else{
						player.setNextWealthGrade(0);
					}
					playerDAO.updateObject(player);
					status = 2;
				}
			}

		}
		this.delRedisPlayer(uid);
		return status;
	}
	
	public Integer updatePlayerHonorGrade(String uid) {
		int status = 0;// 0：玩家不存在;1:荣誉等级更新成功
//		System.out.println("荣誉等级更新");
		String[][] str = new String[][] { { "uid", "=", uid } };
		List<Player> playlist = (List) playerDAO.findparams(null, Player.class, str);
		Player player = playlist.get(0);
		Integer listen=playerDAO.getPlayerListen(uid);
		PlayerGradeInfo entity = playerGradeInfoDAO.findGradeByHonor(
				player.getExperience(), player.getFunsCount(),
				listen,
				player.getSonger());

		if (null != entity) {
			player.setHonor(entity.getGoodNum());
			player.setHonorGrade(entity.getGradeName());
			player.setHonorLogo(entity.getGradeLogo());
			status = 1;
			playerDAO.updateObject(player);
			this.delRedisPlayer(uid);
		}
		return status;
	}
	
	public void delRedisPlayer(String playerId) {
		String key1 = Constants.ConstRedis.R_LOGIN_COMPOSITIONS_Message_PREFIX + "_" + 0 + "_" + playerId;// 玩家作品列表
		String key2 = Constants.ConstRedis.R_PLAYER_Message_PREFIX + "_" + 0 + "_" + playerId;// 玩家信息列表
		redisClientComment.del(key1);// 玩家作品列表
		redisClientComment.del(key2);// 玩家作品列表
		redisClientComment.del(Constants.ConstRedis.R_SHARE_COMPOSITIONS_Message_PREFIX + "_" + 0 + "_" + playerId);// 玩家分享作品列表
		redisClientComment.del(Constants.ConstRedis.R_PLAYER_PHOTO_Message_PREFIX + "_" + 0 + "_" + playerId);// 玩家轮播相片
		redisClientComment.del(Constants.ConstRedis.R_PLAYER_GIFT_Message_PREFIX + "_" + 0 + "_" + playerId);// 玩家礼物列表

		String key3 = Constants.ConstRedis.R_LOGIN_COMPOSITIONS_Message_PREFIX + "_" + 1 + "_" + playerId;// 玩家作品列表
		String key4 = Constants.ConstRedis.R_PLAYER_Message_PREFIX + "_" + 1 + "_" + playerId;// 玩家信息列表
		redisClientComment.del(key3);// 玩家作品列表
		redisClientComment.del(key4);// 玩家作品列表
		redisClientComment.del(Constants.ConstRedis.R_SHARE_COMPOSITIONS_Message_PREFIX + "_" + 1 + "_" + playerId);// 玩家分享作品列表
		redisClientComment.del(Constants.ConstRedis.R_PLAYER_PHOTO_Message_PREFIX + "_" + 1 + "_" + playerId);// 玩家轮播相片
		redisClientComment.del(Constants.ConstRedis.R_PLAYER_GIFT_Message_PREFIX + "_" + 1 + "_" + playerId);// 玩家礼物列表
	}
	
	
}
