package com.lh.appasync.service;

import com.lh.appasync.model.po.PlayerGradeInfo;


public interface IPlayerService {
	
	/**
	 * 玩家获取经验
	 * @param playerId
	 * @param type
	 * @param num
	 */
	public void updatePlayerExperience2(String playerId, Integer type,Integer num);
	
	/**
	 * 清理玩家页面缓存
	 * @param playerId
	 */
	public void delRedisPlayer(String playerId);
}
