package com.serotonin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(name = "name")
	private  String userName;
	@Column(name = "email")
	private String userEmail;
	@Column(name="mobile_number")
	private String userMobileNumber;
	@Column(name = "password")
	private String userPassword;
	
	public User() {
		super();
	}
	
	public User( String userName, String userEmail, String userMobileNumber, String userPassword) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobileNumber = userMobileNumber;
		this.userPassword = userPassword;
	}
	
	public User(int userId, String userName, String userEmail, String userMobileNumber, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobileNumber = userMobileNumber;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(String userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserSignin [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userMobileNumber=" + userMobileNumber + ", userPassword=" + userPassword + "]";
	}
	
	
}
