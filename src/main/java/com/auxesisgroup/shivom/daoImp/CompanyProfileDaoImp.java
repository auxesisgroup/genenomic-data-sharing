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

import com.auxesisgroup.shivom.daoInt.ICompanyProfileDao;
import com.auxesisgroup.shivom.entity.CompanyProfile;

@Repository
@Transactional
public class CompanyProfileDaoImp implements ICompanyProfileDao {

	final static Logger LOGGER = LoggerFactory.getLogger(CompanyProfileDaoImp.class);
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(CompanyProfile companyProfile) {
		try {
			String id = byUserId(companyProfile.companyId).Id;
			if (id != null) {
				companyProfile.Id = id;
				getSession().merge(companyProfile);
				return true;
			}
			companyProfile.Id = UUID.randomUUID().toString();
			getSession().save(companyProfile);
			return true;
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
		}
		return false;
	}

	@Override
	public CompanyProfile byId(String id) {
		this.sessionFactory.getCurrentSession();
		CompanyProfile p = (CompanyProfile) getSession().get(CompanyProfile.class, id);
		return p;
	}

	@Override
	public CompanyProfile byUserId(String companyId) {
		CompanyProfile company = new CompanyProfile();
		Query query = getSession().createQuery("from CompanyProfile where companyId=:companyId");
		query.setParameter("companyId", companyId);
		List results = query.getResultList();
		if (results.size() != 0) {
			company = (CompanyProfile) results.get(0);
		}

		return company;
	}
}
