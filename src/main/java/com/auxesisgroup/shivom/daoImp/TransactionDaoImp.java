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

import com.auxesisgroup.shivom.daoInt.ITransactionDao;
import com.auxesisgroup.shivom.entity.Transaction;

@Repository
@Transactional
public class TransactionDaoImp implements ITransactionDao {

	final static Logger LOGGER = LoggerFactory.getLogger(CompanyProfileDaoImp.class);

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public boolean save(Transaction Transaction) {
		try {
			getSession().save(Transaction);
			return true;
		} catch (Exception ex) {
			LOGGER.error("Exception : " + ex);
		}
		return false;
	}

	@Override
	public List<Transaction> list(String userId) {
		Query query = getSession().createQuery("from Transaction  where userId=:userId");
		query.setParameter("userId", userId);
		return query.list();

	}

	@Override
	public List<Transaction> list() {
		StringBuilder queryString = new StringBuilder("from Transaction");
		Query query = (Query) getSession().createQuery(queryString.toString());
		return query.list();
	}
}
