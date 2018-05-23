package com.auxesisgroup.shivom.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auxesisgroup.shivom.daoInt.ITransactionDao;
import com.auxesisgroup.shivom.entity.Transaction;
import com.auxesisgroup.shivom.serviceInt.ITransaction;



@Service
public class STransaction implements ITransaction {

	@Autowired
	ITransactionDao transactionDao;

	@Override
	public boolean save(Transaction transaction) {
		return transactionDao.save(transaction);
	}

	@Override
	public List<Transaction> list(String userId) {
		return transactionDao.list(userId);
	}

	@Override
	public List<Transaction> list() {
		return transactionDao.list();
	}

}
