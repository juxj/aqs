package com.lh.appasync.service;

import java.util.Map;

import com.lh.appasync.model.po.Comment;

public interface ICompositionService {

    /**
     * 更新评论数
     * @param parmMap
     */
    void updateCommentCount(Map<String, String> parmMap);
    
	/**
	 * 清除作品缓存
	 * 
	 * @param compositionId
	 */
	public void delRedisComposition(String compositionId);
    
}
