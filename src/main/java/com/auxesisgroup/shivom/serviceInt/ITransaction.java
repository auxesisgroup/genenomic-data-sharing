package com.auxesisgroup.shivom.serviceInt;

import java.util.List;

import com.auxesisgroup.shivom.entity.Transaction;

public interface ITransaction {

	public boolean save(Transaction Transaction);

	public List<Transaction> list(String userId);

	public List<Transaction> list();
}
