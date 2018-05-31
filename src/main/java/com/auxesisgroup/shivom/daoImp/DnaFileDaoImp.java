package com.auxesisgroup.shivom.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.auxesisgroup.shivom.daoInt.IDnaFileDao;
import com.auxesisgroup.shivom.entity.DnaFile;
import com.auxesisgroup.shivom.entity.DonorHealthSurvey;
import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Signup;
import com.auxesisgroup.shivom.entity.Transaction;

@Repository
@Transactional
public class DnaFileDaoImp implements IDnaFileDao {

	final static Logger LOGGER = LoggerFactory.getLogger(DnaFileDaoImp.class);
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(DnaFile dnaFile) {
		try {
			LOGGER.info("file Details : " + dnaFile.toString());
			getSession().save(dnaFile);
			return true;
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
		}
		return false;
	}

	@Override
	public List<DnaFile> list() {
		StringBuilder queryString = new StringBuilder("from DnaFile");
		Query query = (Query) getSession().createQuery(queryString.toString());
		return query.list();
	}

	@Override
	public DnaFile byId(String id) {
		this.sessionFactory.getCurrentSession();
		DnaFile p = (DnaFile) getSession().get(DnaFile.class, id);
		return p;
	}

	// @Override
	// public DnaFile byHash(String id) {
	// this.sessionFactory.getCurrentSession();
	// DnaFile p = (DnaFile) getSession().get(DnaFile.class, id);
	// return p;
	// }
	//

	@Override
	public DnaFile byHash(String fileHash) {
		DnaFile user = new DnaFile();
		try {
			System.out.println("username" + fileHash);
			Query query = getSession().createQuery("from DnaFile  where fileHash=:fileHash");
			query.setParameter("fileHash", fileHash);
			List results = query.getResultList();
			if (results.size() == 0) {
				return user;
			}
			return (DnaFile) results.get(0);
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
			return user;
		}
	}

	@Override
	public List<DnaFile> getByUserId(String userId) {
		Query query = getSession().createQuery("from DnaFile where userId=:userId");
		query.setParameter("userId", userId);
		List results = query.getResultList();
		return results;

	}

}
