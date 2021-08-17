package edu.neu.csye7374.model;

import java.io.Serializable;

public class Account implements Serializable{
	
	private String userName;
	private String password;
	private String status;
	
	
	public Account() {
		this.userName = "user";
		this.password = "password";
	
	}
	
	

	public Account(String userName, String password, String status) {
		super();
		this.userName = userName;
		this.password = password;
		this.status = status;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Account(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String resetPassword(String newPasword) {
		this.setPassword(newPasword);
		return this.getPassword();
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
