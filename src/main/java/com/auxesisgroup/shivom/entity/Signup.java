package com.auxesisgroup.shivom.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_details")
public class Signup {

	@Id
	@Column(name = "Id")
	private String Id;

	@NotNull(message = "username cannot be null.")
	@Column(name = "username")
	private String username;

	@NotNull(message = "password cannot be null.")
	@Column(name = "password")
	private String password;

	@Column(name = "created_on")
	private Timestamp createdOn;

	@NotNull(message = "role cannot be null.")
	@Column(name = "role")
	private int role;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Signup [Id=" + Id + ", username=" + username + ", password=" + password + ", createdOn=" + createdOn
				+ ", role=" + role + "]";
	}

}
