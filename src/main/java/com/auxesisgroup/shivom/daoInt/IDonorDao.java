package com.auxesisgroup.shivom.daoInt;

import java.util.List;

import com.auxesisgroup.shivom.entity.Donor;
import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Signup;
import com.auxesisgroup.shivom.entity.Transaction;

public interface IDonorDao {

	public boolean fileTransactionSave(Transaction FileTransaction);

	public List<Donor> list();

	public boolean save(Donor donor_details);

	public Keypair getById(String id);

	public Signup userById(String username);

}
