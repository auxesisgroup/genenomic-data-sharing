package com.auxesisgroup.shivom.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "genomic_file")
public class DnaFile {
	@Id
	@Column(name = "Id")
	private String id;

	@NotNull(message = "fileHash cannot be null.")
	@Column(name = "file_hash")
	private String fileHash;

	@NotNull(message = "userId cannot be null.")
	@Column(name = "user_id")
	private String userId;

	@NotNull(message = "fileName cannot be null.")
	@Column(name = "file_name")
	private String fileName;

	@Column(name = "file_data")
	private String fileData;

	@Column(name = "file_location")
	private String fileLocation;

	@Column(name = "user_address")
	private String userAddress;

	@Column(name = "tokens")
	private BigInteger tokens;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileHash() {
		return fileHash;
	}

	public void setFileHash(String fileHash) {
		this.fileHash = fileHash;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileData() {
		return fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public BigInteger getTokens() {
		return tokens;
	}

	public void setTokens(BigInteger tokens) {
		this.tokens = tokens;
	}

	@Override
	public String toString() {
		return "DnaFile [id=" + id + ", fileHash=" + fileHash + ", userId=" + userId + ", fileName=" + fileName
				+ ", fileData=" + fileData + ", fileLocation=" + fileLocation + ", userAddress=" + userAddress
				+ ", tokens=" + tokens + "]";
	}

}
