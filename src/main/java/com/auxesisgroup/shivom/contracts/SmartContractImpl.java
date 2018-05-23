
package com.auxesisgroup.shivom.contracts;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;

import com.auxesisgroup.shivom.entity.DnaFile;
import com.auxesisgroup.shivom.entity.Response;
import com.auxesisgroup.shivom.entity.Transaction;
import com.auxesisgroup.shivom.entity.TxHash;
import com.auxesisgroup.shivom.serviceInt.ITransaction;
import com.auxesisgroup.shivom.smartcontract.Shivom;

@Service
@Configuration
@PropertySource("classpath:blockchain.properties")
public class SmartContractImpl implements ISmartContract {

	// @Value("${web3j.url}")
	private String webUrl = "http://139.59.213.205:7007";

	// @Value("${web3j.masterKey}")
	// private String masterKey;

	// BlochchainProperties _BlochchainProperties = new BlochchainProperties();
	// variable
	final static Logger LOGGER = LoggerFactory.getLogger(SmartContractImpl.class);
	String contractAddress = "0x16b6c6d62e8847c947e771950eb6ef2586bfce7b";
	private Web3j web3 = Web3j.build(new HttpService(webUrl));
	private String senderPrivKey = "0xc2abb8b84b2ebec63f9eede827b08d81ab42513d504dfc44650cacd62c13cd51";

	// Addrress : 0x1b4c27004995c6f5e37e42d25002a8750b156e8d
	// private String gasPrice = "99999999999";
	Credentials creds = Credentials.create(senderPrivKey);
	// private BigInteger _gasPrice = new BigInteger(gasPrice);
	BigInteger _gasLimit = BigInteger.valueOf(3999756);

	@Autowired
	ITransaction transactionDetails;

	@Override
	public Response smartContractDeploy() {
		Response res = new Response();

		try {
			BigInteger _gasLimit = BigInteger.valueOf(2099756);
			BigInteger _garPrice = BigInteger.valueOf(1);
			Shivom contract = Shivom.deploy(web3, creds, _garPrice, _gasLimit).sendAsync().get();
			if (!contract.isValid()) {
				res.setMessage("Invalid contract");
				return res;
			}
			res.setResult(contract.getContractAddress());
			return res;
		} catch (Exception ex) {
			LOGGER.error("Expection :" + ex);
			res.setMessage("Error");
			return res;
		}
	}

	@Override
	public Response addUser(DnaFile DonorFileDetails) {
		Response res = new Response();
		try {
			BigInteger _gasLimit = BigInteger.valueOf(1068756);
			BigInteger _garPrice = BigInteger.valueOf(1068756);
			Shivom contract = Shivom.load(contractAddress, web3, creds, _garPrice, _gasLimit);
			if (!contract.isValid()) {
				res.setMessage("Invalid contract");
				return res;
			}

			TransactionReceipt transact = contract
					.login(DonorFileDetails.getUserAddress(), DonorFileDetails.getTokens()).sendAsync().get();

			res.setResult(transact);
			return res;
		} catch (Exception ex) {
			LOGGER.error("Expection :" + ex);
			res.setMessage("Exception");

			return res;
		}
	}

	@Override
	public Response fileHashMapping(DnaFile donorFileDetails) {
		Response res = new Response();
		try {
			LOGGER.info("fileHash : " + donorFileDetails.getFileHash());
			LOGGER.info("userAddress : " + donorFileDetails.getUserAddress());
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(donorFileDetails.getFileHash().getBytes());
			byte[] hash = md.digest();
			String myHash = DatatypeConverter.printHexBinary(hash).toUpperCase();
			LOGGER.info("fileHash integer Hash: " + new String(hash));
			StringBuilder sb = new StringBuilder();
			byte[] b = myHash.getBytes();

			for (byte ch : b) {
				sb.append((byte) ch);
			}
			LOGGER.info("fileHash integer : " + sb.toString());
			BigInteger _fileHash = new BigInteger(sb.toString());

			BigInteger _gasLimit = BigInteger.valueOf(2068756);
			BigInteger _garPrice = BigInteger.valueOf(2068756);
			Shivom contract = Shivom.load(contractAddress, web3, creds, _garPrice, _gasLimit);
			if (!contract.isValid()) {
				res.setMessage("Invalid contract");
				return res;
			}
			TransactionReceipt transact = contract.fileUpload(donorFileDetails.getUserAddress(), _fileHash).sendAsync()
					.get();

			TransactionReceipt transact2 = contract
					.login(donorFileDetails.getUserAddress(), donorFileDetails.getTokens()).sendAsync().get();

			Transaction trs = new Transaction();
			trs.setTransactionId(transact2.getTransactionHash());
			trs.setFileHash(donorFileDetails.getFileHash());
			trs.setAddress(donorFileDetails.getUserAddress());
			trs.setUserId(donorFileDetails.getUserId());
			trs.setTokens(donorFileDetails.getTokens());
			trs.setId(UUID.randomUUID().toString());
			LOGGER.info("Transaction " + trs.toString());
			Boolean save = transactionDetails.save(trs);
			LOGGER.info("save or not " + save);
			res.setResult(transact);
			return res;
		} catch (Exception ex) {
			LOGGER.error("fileHashMapping : " + ex);
			res.setMessage("Exception" + ex);
			return res;
		}
	}

	@Override
	public Response getFile(DnaFile donorFileDetails) {
		Response res = new Response();
		try {

			LOGGER.info("fileHash : " + donorFileDetails.getFileHash());
			LOGGER.info("userAddress : " + donorFileDetails.getUserAddress());
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(donorFileDetails.getFileHash().getBytes());
			byte[] hash = md.digest();
			String myHash = DatatypeConverter.printHexBinary(hash).toUpperCase();
			LOGGER.info("fileHash integer Hash: " + new String(hash));
			StringBuilder sb = new StringBuilder();
			byte[] b = myHash.getBytes();

			for (byte ch : b) {
				sb.append((byte) ch);
			}
			LOGGER.info("fileHash integer : " + sb.toString());
			BigInteger fileHash = new BigInteger(sb.toString());

			BigInteger _gasLimit = BigInteger.valueOf(1068756);
			BigInteger _garPrice = BigInteger.valueOf(1068756);
			Shivom contract = Shivom.load(contractAddress, web3, creds, _garPrice, _gasLimit);
			if (!contract.isValid()) {
				res.setMessage("Invalid contract");
				return res;
			}
			TransactionReceipt transact = contract
					.download(fileHash, donorFileDetails.getTokens(), donorFileDetails.getUserAddress()).sendAsync()
					.get();
			res.setResult(transact);
			return res;
		} catch (Exception ex) {
			res.setMessage("Exception : " + ex);
			return res;
		}
	}

	@Override
	public Response getWalletBalance(String userAddress) {
		Response res = new Response();
		try {
			BigInteger _gasLimit = BigInteger.valueOf(1068756);
			BigInteger _garPrice = BigInteger.valueOf(1068756);
			Shivom contract = Shivom.load(contractAddress, web3, creds, _garPrice, _gasLimit);
			if (!contract.isValid()) {
				res.setMessage("Invalid contract");
				return res;
			}
			Tuple2<String, BigInteger> transact = contract.getUserInfo(userAddress).sendAsync().get();
			TxHash result = new TxHash(transact.getValue1().toString(), transact.getValue2(), null);
			res.setResult(result);
			return res;
		} catch (Exception ex) {
			LOGGER.error("Expection :" + ex);
			res.setMessage("Exception" + ex);

			return res;
		}
	}

	@Override
	public Response getFileHashDetails(String fileHash) {
		Response res = new Response();
		try {
			LOGGER.info("fileHash : " + fileHash);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(fileHash.getBytes());
			byte[] hash = md.digest();
			String myHash = DatatypeConverter.printHexBinary(hash).toUpperCase();
			LOGGER.info("fileHash integer Hash: " + new String(hash));
			StringBuilder sb = new StringBuilder();
			byte[] b = myHash.getBytes();
			for (byte ch : b) {
				sb.append((byte) ch);
			}
			LOGGER.info("fileHash integer : " + sb.toString());
			BigInteger _fileHash = new BigInteger(sb.toString());
			BigInteger _gasLimit = BigInteger.valueOf(1068756);
			BigInteger _garPrice = BigInteger.valueOf(1);
			Shivom contract = Shivom.load(contractAddress, web3, creds, _garPrice, _gasLimit);
			if (!contract.isValid()) {
				res.setMessage("Invalid contract");
				return res;
			}
			Tuple2<List<Address>, List<Uint256>> transact = contract.getFileUserList(_fileHash).sendAsync().get();
			LOGGER.info("file Hash : " + transact.getValue1().size());
			// if (transact.getValue1().size() == 0) {
			// res.setMessage("Data not found.");
			// return res;
			// }
			List<DnaFile> result = new ArrayList<DnaFile>();
			List<Address> address = transact.getValue1();
			List<Uint256> tokens = transact.getValue2();
			for (int i = 0; i < transact.getValue1().size(); i++) {
				DnaFile data = new DnaFile();
				System.out.println(address.get(i));
				data.setUserAddress(address.get(i).toString());
				data.setTokens(tokens.get(i).getValue());
				result.add(data);
			}

			res.setResult(result);
			return res;
		} catch (Exception ex) {
			res.setMessage("Exception" + ex);
			return res;
		}
	}

	@Override
	public Response getUplodedFileUserList(String userId) {
		Response res = new Response();
		try {

			BigInteger _gasLimit = BigInteger.valueOf(1068756);
			BigInteger _garPrice = BigInteger.valueOf(1);
			Shivom contract = Shivom.load(contractAddress, web3, creds, _garPrice, _gasLimit);
			if (!contract.isValid()) {
				res.setMessage("Invalid contract");
				return res;
			}
			Tuple2<List<BigInteger>, String> transact = contract.getUplodedFileUserList(userId).sendAsync().get();

			// if (transact.getValue1().size() == 0) {
			// res.setMessage("Data not found.");
			// return res;
			// }
			// List<BigInteger> tokens = transact.getValue1();
			// for (int i = 0; i < transact.getValue1().size(); i++) {
			// DnaFile data = new DnaFile();
			// System.out.println(address.get(i));
			// data.setUserAddress(address.get(i).toString());
			// data.setTokens(tokens.get(i).getValue());
			// result.add(data);
			// }

			res.setResult(transact);
			return res;
		} catch (Exception ex) {
			res.setMessage("Exception" + ex);
			return res;
		}
	}

}
