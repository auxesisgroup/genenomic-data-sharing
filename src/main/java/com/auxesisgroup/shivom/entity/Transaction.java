package com.auxesisgroup.shivom.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

	
//	`id`, `user_id`, `transaction_id`, `created_on`, `address`, `token`, `status`, `file_hash`
	
	
	@Id
	@Column(name = "Id")
	private String Id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "token")
	private BigInteger tokens;

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "file_hash")
	private String fileHash;

	@Column(name = "status")
	private boolean status;
	
	@Column(name = "address")
	private String address;

	@Column(name = "created_on")
	private Timestamp createdOn;

	public String isAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigInteger getTokens() {
		return tokens;
	}

	public void setTokens(BigInteger tokens) {
		this.tokens = tokens;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transationId) {
		this.transactionId = transationId;
	}

	public String getFileHash() {
		return fileHash;
	}

	public void setFileHash(String file_hash) {
		this.fileHash = file_hash;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Transaction [Id=" + Id + ", userId=" + userId + ", tokens=" + tokens + ", transationId=" + transactionId
				+ ", fileHash=" + fileHash + ", status=" + status + ", address=" + address + ", createdOn=" + createdOn
				+ "]";
	}

}
