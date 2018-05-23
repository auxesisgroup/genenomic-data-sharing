package com.auxesisgroup.shivom.serviceImp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auxesisgroup.shivom.contracts.ISmartContract;
import com.auxesisgroup.shivom.daoInt.IDonorDao;
import com.auxesisgroup.shivom.daoInt.IKeypairDao;
import com.auxesisgroup.shivom.entity.Donor;
import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Response;
import com.auxesisgroup.shivom.serviceInt.IDonor;

@Service
public class SDonor implements IDonor {

	final static Logger LOGGER = LoggerFactory.getLogger(SDonor.class);

	@Autowired
	IDonorDao donorDetailsDaoInt;

	@Autowired
	ISmartContract contract;
	// rpcCalls rcpcall = new rpcCalls();

	@Autowired
	IKeypairDao KeypairDao;

	@Override
	public List<Donor> list() {
		return donorDetailsDaoInt.list();
	}

	@Override
	public boolean save(Donor donor) {
		return donorDetailsDaoInt.save(donor);
	}

	public Keypair getById(String id) {
		return donorDetailsDaoInt.getById(id);
	}

	

	public Response getBalance(String userId) {
		Response res = new Response();
		try {
			res = KeypairDao.getById(userId);
			if (res.getMessage() != null) {
				return res;
			}
			Keypair cre = (Keypair) res.getResult();
			res = contract.getWalletBalance(cre.getAddress());
			return res;
		} catch (Exception e) {
			LOGGER.error("Exception :" + e);
			res.setMessage("Error" + e);
			res.setResult(null);
			return res;
		}
	}

	public Response getFileDetails(String fileHash) {
		Response res = new Response();
		try {
			res = contract.getFileHashDetails(fileHash);
			if (res.getMessage() != null) {
				return res;
			}
			return res;
		} catch (Exception e) {
			LOGGER.error("Exception :" + e);
			res.setMessage("Exception : " + e);
			res.setResult(null);
			return res;
		}
	}

}
