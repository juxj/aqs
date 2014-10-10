package com.lh.appasync.dao;

import com.lh.appasync.model.po.Player;

public interface IPlayerDAO extends IBaseDAO <Player, String> {

	/**
	 * 获取玩家收听数目
	 * @param uid
	 * @return
	 */
	public Integer getPlayerListen(String uid);
}
