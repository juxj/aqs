package com.lh.appasync.dao.impl;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lh.appasync.dao.IPlayerDAO;
import com.lh.appasync.model.po.Player;

public class PlayerDAOImpl extends BaseDAOImpl<Player, String> implements IPlayerDAO {

	@Override
	@Transactional("tmTestMaster")
	public Integer getPlayerListen(String uid) {
		String sql="select count(1) from composition_record cr where cr.play_id=:playerId ";
		Query query = this.getTestMasterSession().createSQLQuery(sql);
		query.setParameter("playerId", uid);
		Integer l=Integer.parseInt(query.uniqueResult()+"");
		return l;
	}
    
}
