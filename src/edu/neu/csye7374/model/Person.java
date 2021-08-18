package edu.neu.csye7374.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person extends Account implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int personId;

	private int roleId; //ID=1 is Manager, ID=2 is HR, ID=3 is Supplier

	private String firstName;

	private String lastName;

	private String emailId;

	private Date dob;

	private String address;

	private Account account;
	

	public Person() {
		this.personId = 0;
		this.roleId = 0;
		this.firstName = "Dan";
		this.lastName = "Peters";
		this.emailId = "d.peters@northeastern.edu";
		String oldstring = "2003-01-01 00:00:00.0";
		try {
			this.dob = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.address = "NH";
		this.account = new Account();
		this.account.setUserName(String.valueOf(personId));
	}

	public Person(int personId, int roleId, String firstName, String lastName, String emailId, Date dob, String address,
			Account account) {
		super();
		this.personId = personId;
		this.roleId = roleId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.address = address;
		this.account = account;
		this.account.setUserName(String.valueOf(personId));
	}

	
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", roleId=" + roleId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", dob=" + dob + ", address=" + address + ", account=" + account
				+ "]";
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
