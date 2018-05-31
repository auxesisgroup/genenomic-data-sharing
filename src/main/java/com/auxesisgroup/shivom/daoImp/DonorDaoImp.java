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

import com.auxesisgroup.shivom.daoInt.IDonorDao;
import com.auxesisgroup.shivom.entity.Donor;
import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Signup;
import com.auxesisgroup.shivom.entity.Transaction;

@Repository
@Transactional
public class DonorDaoImp implements IDonorDao {
	final static Logger LOGGER = LoggerFactory.getLogger(DonorDaoImp.class);

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public boolean fileTransactionSave(Transaction transaction) {
		try {
			getSession().save(transaction);
			return true;
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
			System.out.println("fileTransactionSave : " + ex);
		}
		return false;
	}

	@Override
	public List<Donor> list() {
		StringBuilder queryString = new StringBuilder("from Donor");
		Query query = (Query) getSession().createQuery(queryString.toString());
		return query.list();
	}

	@Override
	public boolean save(Donor donor) {
		try {

			String id = donorById(donor.getDonorId()).getId();
			if (id != null) {
				donor.setId(id);
				getSession().merge(donor);
				return true;
			}
			donor.setId(UUID.randomUUID().toString());
			getSession().save(donor);
			return true;
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
			System.out.println("login ........." + ex);
		}
		return false;
	}

	@Override
	public Keypair getById(String id) {
		this.sessionFactory.getCurrentSession();
		Keypair p = (Keypair) getSession().get(Keypair.class, id);
		return p;
	}

	@Override
	public Signup userById(String username) {
		Signup user = new Signup();
		try {
			System.out.println("username" + username);
			Query query = getSession().createQuery("from Signup  where username=:username");
			query.setParameter("username", username);
			List results = query.getResultList();
			if (results.size() == 0) {
				return user;
			}
			return (Signup) results.get(0);
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
			return user;
		}
	}

	public Donor donorById(String donorId) {
		Donor user = new Donor();
		try {
			System.out.println("username" + donorId);
			Query query = getSession().createQuery("from Donor  where donorId=:donorId");
			query.setParameter("donorId", donorId);
			List results = query.getResultList();
			if (results.size() == 0) {
				return user;
			}
			return (Donor) results.get(0);
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
			return user;
		}
	}

}
