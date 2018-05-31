package com.auxesisgroup.shivom.daoImp;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.auxesisgroup.shivom.daoInt.IDonorHealthSurveyDao;
import com.auxesisgroup.shivom.entity.DonorHealthSurvey;

@Repository
@Transactional
public class DonorHealthSurveyDaoImp implements IDonorHealthSurveyDao {

	final static Logger LOGGER = LoggerFactory.getLogger(DonorHealthSurveyDaoImp.class);
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(DonorHealthSurvey donorHealthSurvey) {

		try {
			String id = getById(donorHealthSurvey.userId).Id;
			if (id != null) {
				donorHealthSurvey.Id = id;
				getSession().merge(donorHealthSurvey);
				return true;
			}
			donorHealthSurvey.Id = UUID.randomUUID().toString();
			getSession().save(donorHealthSurvey);
			return true;
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
		}
		return false;
	}

	@Override
	public DonorHealthSurvey getById(String userId) {
		DonorHealthSurvey healthaSurvey = new DonorHealthSurvey();
		Query query = getSession().createQuery("from DonorHealthSurvey where userId=:userId");
		query.setParameter("userId", userId);
		List results = query.getResultList();
		if (results.size() != 0) {
			return (DonorHealthSurvey) results.get(0);
		}
		return healthaSurvey;
	}
}
