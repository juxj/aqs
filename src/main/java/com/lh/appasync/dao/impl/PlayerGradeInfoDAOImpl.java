package com.lh.appasync.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lh.appasync.dao.IPlayerGradeInfoDAO;
import com.lh.appasync.model.po.PlayerGradeInfo;

public class PlayerGradeInfoDAOImpl extends BaseDAOImpl<PlayerGradeInfo, Integer> implements IPlayerGradeInfoDAO {

	@Override
	@Transactional("tmTestMaster")
	public PlayerGradeInfo findGradeBySonger(Integer songerPopular) {
		Query query = getTestMasterSession().getNamedQuery("findGradeBySonger");
		query.setParameter("songGradeRules", songerPopular);

		List<PlayerGradeInfo> list = query.list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional("tmTestMaster")
	public PlayerGradeInfo findGradeByWealth(Double wealthPopular) {
		Query query = this.getTestMasterSession().getNamedQuery("findGradeByWealth");
		query.setParameter("wealthPopular", wealthPopular);
		List<PlayerGradeInfo> list = query.list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional("tmTestMaster")
	public PlayerGradeInfo findGradeByHonor(Double experience, Integer focus,
			Integer listen, Integer grade) {
		Query query = this.getTestMasterSession().getNamedQuery("findGradeByHonor");
		query.setParameter("experience", experience);
		query.setParameter("focus", focus);
		query.setParameter("listen", listen);
		query.setParameter("grade", grade);
		List<PlayerGradeInfo> list = query.list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
