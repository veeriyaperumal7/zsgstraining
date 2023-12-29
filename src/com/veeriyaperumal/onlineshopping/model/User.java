package com.veeriyaperumal.onlineshopping.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class User {

	private int userId;
	private String user_Name, fullName, gender, address, mobileNumber, emailAddress, password;
	private Date dob;

	public User() {

	}

	public User(int userId, String user_Name, String fullName, String gender, String address, String mobileNumber,
			String emailAddress, String password, Date dob) {
		this.userId = userId;
		this.user_Name = user_Name;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.dob = dob;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return user_Name;
	}

	public void setName(String name) {
		this.user_Name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmail_Address(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return "User{" + "\nuserId=" + userId + "\nuser_Name='" + user_Name + "\nfullName='" + fullName + "\ngender='"
				+ gender + "\naddress='" + address + "\nmobileNumber='" + mobileNumber + "\nemailAddress='"
				+ emailAddress + "\npassword='" + password + "\ndob=" + (dob != null ? dateFormat.format(dob) : "null")
				+ "\n}";
	}

}
