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
import com.auxesisgroup.shivom.daoInt.IKeypairDao;
import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Response;

@Repository
@Transactional
public class KeypairDaoImp implements IKeypairDao {

	final static Logger LOGGER = LoggerFactory.getLogger(KeypairDaoImp.class);

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Response getById(String userId) {
		Response res = new Response();
		try {
			LOGGER.info("getById : " + userId);
			Query query = getSession().createQuery("from Keypair where userId=:userId");
			query.setParameter("userId", userId);
			List results = query.getResultList();
			LOGGER.info("size of an array : " + results.size());
			if (results.size() == 0) {
				res.setMessage("No data found.");
				res.setResult(null);
				return res;
			}
			res.setResult(results.get(0));
			Keypair keypair = (Keypair) results.get(0);
			LOGGER.info("keypair : " + keypair.toString());
			return res;
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
			res.setMessage("Exception : " + ex);
			res.setResult(null);
		}
		return res;
	}
}
