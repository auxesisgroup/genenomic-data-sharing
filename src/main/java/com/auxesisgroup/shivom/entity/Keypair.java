package com.auxesisgroup.shivom.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wallet_details")
public class Keypair {

	@Id
	@Column(name = "Id")
	private String Id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "address")
	private String address;

	@Column(name = "pubkey")
	private String pubkey;

	@Column(name = "privkey")
	private String privkey;

	@Column(name = "created_on")
	private Timestamp createdOn;

	@Column(name = "signId")
	private String signId;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPubkey() {
		return pubkey;
	}

	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}

	public String getPrivkey() {
		return privkey;
	}

	public void setPrivkey(String privkey) {
		this.privkey = privkey;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getSignId() {
		return signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public Keypair(String id, String userId, String address, String pubkey, String privkey, String signId) {
		super();
		Id = id;
		this.userId = userId;
		this.address = address;
		this.pubkey = pubkey;
		this.privkey = privkey;
		this.signId = signId;
	}

	public Keypair() {
		super();

	}

	@Override
	public String toString() {
		return "CreateKeyPair [Id=" + Id + ", userId=" + userId + ", address=" + address + ", pubkey=" + pubkey
				+ ", createdOn=" + createdOn + ", signId=" + signId + "]";
	}

}
