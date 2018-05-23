package com.auxesisgroup.shivom.serviceImp;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.auxesisgroup.shivom.contracts.ISmartContract;
import com.auxesisgroup.shivom.daoInt.IDnaFileDao;
import com.auxesisgroup.shivom.daoInt.IDonorDao;
import com.auxesisgroup.shivom.daoInt.IKeypairDao;
import com.auxesisgroup.shivom.entity.DnaFile;
import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Response;
import com.auxesisgroup.shivom.entity.Transaction;
import com.auxesisgroup.shivom.entity.TxHash;
import com.auxesisgroup.shivom.serviceInt.IDnaFile;
import com.auxesisgroup.shivom.serviceInt.IKeypair;
import com.auxesisgroup.shivom.serviceInt.ITransaction;

@Service
public class SDnaFile implements IDnaFile {
	final static Logger LOGGER = LoggerFactory.getLogger(IDnaFile.class);

	@Autowired
	IDonorDao donorDetailsDaoInt;

	@Autowired
	ISmartContract contract;

	@Autowired
	IDnaFileDao DnaFile;

	@Autowired
	IKeypair Keypair;

	@Autowired
	IKeypairDao KeypairDao;

	@Autowired
	ITransaction transctionDetail;

	@Override
	public Response save(DnaFile donorFileDetails) {
		Response res = new Response();
		try {
			String id =byHash(donorFileDetails.getFileHash()).getId();
			if (id!= null) {
				res.setMessage("File is already exist.");
				return res;
			}
			res = Keypair.getById(donorFileDetails.getUserId());
			if (res.getMessage() != null) {
				return res;
			}
			Keypair cre = (Keypair) res.getResult();
			System.out.println("Credintial info : " + cre.toString());
			DnaFile fileDetails = new DnaFile();
			fileDetails.setUserAddress(cre.getAddress());
			fileDetails.setFileHash(donorFileDetails.getFileHash());
			fileDetails.setUserId(donorFileDetails.getUserId());
			fileDetails.setTokens(BigInteger.valueOf(10));
			res = contract.fileHashMapping(fileDetails);
			if (res.getMessage() != null) {
				System.out.println(res.getMessage());
				return res;
			}
			LOGGER.info("info : " + res.toString());
			TransactionReceipt transact = (TransactionReceipt) res.getResult();
			donorFileDetails.setId(UUID.randomUUID().toString());

			boolean save = DnaFile.save(donorFileDetails);
			LOGGER.info("save : " + save);
			return res;
		} catch (Exception e) {
			LOGGER.error("Exception :" + e);
			res.setMessage("Exception : " + e);
			res.setResult(null);
			return res;

		}
	}

	public Response fileAccess(DnaFile donorFileDetails) {
		Response res = new Response();
		try {
			res = KeypairDao.getById(donorFileDetails.getUserId());
			if (res.getMessage() != null) {
				return res;
			}
			Keypair cre = (Keypair) res.getResult();
			DnaFile fileDetails = new DnaFile();
			fileDetails.setUserAddress(cre.getAddress());
			fileDetails.setFileHash(donorFileDetails.getFileHash());
			fileDetails.setTokens(BigInteger.valueOf(20));
			fileDetails.setUserId(donorFileDetails.getUserId());
			res = contract.getFile(fileDetails);
			if (res.getMessage() != null) {
				System.out.println(res.getMessage());
				return res;
			}

			TransactionReceipt transact = (TransactionReceipt) res.getResult();
			Transaction fileTransaction = new Transaction();
			fileTransaction.setUserId(donorFileDetails.getUserId());
			fileTransaction.setFileHash(donorFileDetails.getFileHash());
			fileTransaction.setTokens(BigInteger.valueOf(20));
			fileTransaction.setId(UUID.randomUUID().toString());
			fileTransaction.setTransactionId(transact.getTransactionHash());
			fileTransaction.setAddress(cre.getAddress());
			transctionDetail.save(fileTransaction);
			TxHash tx = new TxHash(null, null, transact.getTransactionHash());
			res.setResult(tx);
			return res;
		} catch (Exception e) {
			res.setResult(null);
			LOGGER.error("Exception : " + e);
			res.setMessage("Exception : " + e);
			return res;
		}
	}

	@Override
	public List<com.auxesisgroup.shivom.entity.DnaFile> list() {
		return DnaFile.list();
	}

	@Override
	public com.auxesisgroup.shivom.entity.DnaFile byId(String id) {
		return DnaFile.byId(id);
	}

	@Override
	public com.auxesisgroup.shivom.entity.DnaFile byHash(String fileHash) {
		return DnaFile.byHash(fileHash);
	}

	@Override
	public List<com.auxesisgroup.shivom.entity.DnaFile> getByUserId(String userId) {
		return DnaFile.getByUserId(userId);
	}

}
