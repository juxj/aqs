package com.lh.appasync.dao.impl;

import java.util.Map;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lh.appasync.dao.ICompositionDAO;
import com.lh.appasync.model.po.Composition;

public class CompositionDAOImpl extends BaseDAOImpl<Composition, String> implements ICompositionDAO {

    
	@Override
	@Transactional("tmMyStyleMaster")
	public void updateCommentCount(String sqlQuery, Map<String, Object> param) {
		try {
			Query query = getMyStyleMasterSession().getNamedQuery(sqlQuery);
			this.initQueryParam(query, param);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
