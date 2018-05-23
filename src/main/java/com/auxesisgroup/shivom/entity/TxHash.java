package com.auxesisgroup.shivom.entity;

import java.math.BigInteger;

public class TxHash {
	private BigInteger token;
	private String address;
	private String transactionHash;

	public BigInteger getToken() {
		return token;
	}

	public void setToken(BigInteger token) {
		this.token = token;
	}

	public String getTransactionHash() {
		return transactionHash;
	}

	public void setTransactionHash(String transactionHash) {
		this.transactionHash = transactionHash;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TxHash(String address,BigInteger token, String transactionHash) {
		super();
		this.address = address;
		this.token = token;
		this.transactionHash = transactionHash;
	}

	@Override
	public String toString() {
		return "TxHash [token=" + token + ", address=" + address + ", transactionHash=" + transactionHash + "]";
	}

}
