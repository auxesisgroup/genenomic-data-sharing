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

import com.auxesisgroup.shivom.daoInt.ISignupDao;
import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Signup;



@Repository
@Transactional
public class SignupDaoImp implements ISignupDao {

	final static Logger LOGGER = LoggerFactory.getLogger(SignupDaoImp.class);

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public boolean signup(Signup signUp, Keypair createkeypairs) {
		try {
			getSession().save(signUp);
			getSession().save(createkeypairs);
			LOGGER.info(signUp.getUsername() + "signup successfully");
			return true;
		} catch (Exception ex) {
			LOGGER.error("Exception in signup " + signUp.getUsername() + " : " + ex);
		}
		return false;
	}

	@Override
	public Signup login(Signup signup) {
		Signup user = new Signup();
		try {
			Query query = getSession()
					.createQuery("from Signup  where username=:username and password=:password and role=:role");
			query.setParameter("username", signup.getUsername());
			query.setParameter("password", signup.getPassword());
			query.setParameter("role", signup.getRole());
			List results = query.getResultList();
			return (Signup) results.get(0);
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
			System.out.println("Exception in login : " + ex);
			return user;
		}
	}
}
