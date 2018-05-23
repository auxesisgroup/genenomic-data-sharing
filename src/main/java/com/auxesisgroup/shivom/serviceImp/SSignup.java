package com.auxesisgroup.shivom.serviceImp;

import java.math.BigInteger;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Hash;

import com.auxesisgroup.shivom.contracts.ISmartContract;
import com.auxesisgroup.shivom.daoInt.IDonorDao;
import com.auxesisgroup.shivom.daoInt.ISignupDao;
import com.auxesisgroup.shivom.entity.DnaFile;
import com.auxesisgroup.shivom.entity.Keypair;
import com.auxesisgroup.shivom.entity.Response;
import com.auxesisgroup.shivom.entity.Signup;
import com.auxesisgroup.shivom.serviceInt.ISignup;

@Service
public class SSignup implements ISignup {
	final static Logger LOGGER = LoggerFactory.getLogger(SSignup.class);

	@Autowired
	ISignupDao SignupDao;

	@Autowired
	IDonorDao donorDao;

	@Autowired
	ISmartContract contract;

	public Response signup(Signup signup) {
		Response res = new Response();
		try {
			LOGGER.info("################### sign up ######################");
			Signup user = new Signup();
			user = donorDao.userById(signup.getUsername());
			if (user.getId() != null) {
				LOGGER.error(signup.getUsername() + " username already exist");
				res.setMessage(signup.getUsername() + " username already exist");
				return res;
			}
			String userId = UUID.randomUUID().toString();
			signup.setId(userId);
			String signId = UUID.randomUUID().toString();
			byte[] reci = Hash.sha3(signId.getBytes());
			ECKeyPair keyPair = ECKeyPair.create(reci);
			Credentials creds = Credentials.create(keyPair);
			Keypair keypair = new Keypair(UUID.randomUUID().toString(), userId, creds.getAddress(),
					creds.getEcKeyPair().getPublicKey().toString(), creds.getEcKeyPair().getPrivateKey().toString(),
					signId);
			keypair.setId(UUID.randomUUID().toString());
			keypair.setUserId(userId);
			keypair.setAddress(creds.getAddress());
			keypair.setPubkey(creds.getEcKeyPair().getPublicKey().toString());
			keypair.setPrivkey(creds.getEcKeyPair().getPrivateKey().toString());
			keypair.setSignId(signId);
			LOGGER.info("wallet info of " + signup.getId() + " user : " + signup.toString());
//			if (signup.getRole() == 1) {
//				DnaFile donorFileDetails = new DnaFile();
//				donorFileDetails.setUserAddress(keypair.getAddress());
//				donorFileDetails.setTokens(BigInteger.valueOf(100));
//				res = contract.addUser(donorFileDetails);
//				if (res.getMessage() != null) {
//					return res;
//				}
//
//			}
			boolean success = SignupDao.signup(signup, keypair);
			if (!success) {
				LOGGER.error("Unable to signup : " + signup.getUsername());
				res.setMessage("Unable to signup.");
				return res;
			}
			res.setResult("user signup successfully.");
			return res;
		} catch (Exception e) {

			LOGGER.error("Exception : " + e);
			res.setMessage("Exception : " + e);
			return res;
		}

	}

	@Override
	public Signup login(Signup signup) {
		return SignupDao.login(signup);
	}
}
