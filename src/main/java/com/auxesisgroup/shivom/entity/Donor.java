package com.auxesisgroup.shivom.entity;

import java.sql.Timestamp;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "donor")
public class Donor {

	@Id
	@Column(name = "Id")
	private String Id;

	
	@Column(name = "full_name")
	@NotNull(message = "fullName cannot be null.")
	private String fullName;

	
	@NotNull(message = "emailId cannot be null.")
	@Column(name = "email_id")
	private String emailId;

	
	@NotNull(message = "contactNumber cannot be null.")
	@Column(name = "contact_number")
	private String contactNumber;

	
	@NotNull(message = "address cannot be null.")
	@Column(name = "address")
	private String address;

	
	@NotNull(message = "city cannot be null.")
	@Column(name = "city")
	private String city;

	
	@NotNull(message = "state cannot be null.")
	@Column(name = "state")
	private String state;

	
	@NotNull(message = "country cannot be null.")
	@Column(name = "country")
	private String country;

	
	@NotNull(message = "postalNo cannot be null.")
	@Column(name = "postal_no")
	private String postalNo;

	
	
	@NotNull(message = "donorId cannot be null.")
	@Column(name = "donor_id")
	private String donorId;

	
	@Column(name = "created_on")
	private Timestamp createdOn;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalNo() {
		return postalNo;
	}

	public void setPostalNo(String postalNo) {
		this.postalNo = postalNo;
	}

	public Timestamp getCreatedNn() {
		return createdOn;
	}

	public void setCreatedNn(Timestamp createdNn) {
		this.createdOn = createdNn;
	}

	public String getDonorId() {
		return donorId;
	}

	public void setDonorId(String donorId) {
		this.donorId = donorId;
	}

	@Override
	public String toString() {
		return "Donor [Id=" + Id + ", fullName=" + fullName + ", emailId=" + emailId + ", contactNumber="
				+ contactNumber + ", address=" + address + ", city=" + city + ", state=" + state + ", country="
				+ country + ", postalNo=" + postalNo + ", createdNn=" + createdOn + ", donorId=" + donorId + "]";
	}

}
