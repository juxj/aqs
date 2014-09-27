package com.lh.appasync.dao;

import com.lh.appasync.model.po.PlayerGradeInfo;

public interface IPlayerGradeInfoDAO extends IBaseDAO <PlayerGradeInfo, Integer> {


	/**
	 * 用人气点查找当前等级
	 * @param songerPopular
	 * @return
	 */
	public PlayerGradeInfo findGradeBySonger(Integer songerPopular);
	
	/**
	 * 用财富点查找当前财富等级
	 * @param wealthPopular
	 * @return
	 */
	public PlayerGradeInfo findGradeByWealth(Double wealthPopular);
	
	/**
	 * 查询玩家当前荣誉等级
	 * @param experience
	 * @param focus
	 * @param listen
	 * @param grade
	 * @return
	 */
	public PlayerGradeInfo findGradeByHonor(Double experience,Integer focus,Integer listen,Integer grade);
	
}
