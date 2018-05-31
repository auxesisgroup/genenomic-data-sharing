package com.auxesisgroup.shivom.daoInt;

import java.util.List;

import com.auxesisgroup.shivom.entity.Transaction;

public interface ITransactionDao {
	public boolean save(Transaction Transaction);

	public List<Transaction> list(String userId);

	public List<Transaction> list();

}
