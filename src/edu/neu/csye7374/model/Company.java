package edu.neu.csye7374.model;

import java.util.List;

public class Company {

	private String companyName;
	
	private int companyId;
	
	private String address;
	
	private Inventory inventory;
	
	private List<Person> people;
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public int getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public List<Person> getPeople() {
		return people;
	}
	
	public void setPeople(List<Person> people) {
		this.people = people;
	}
	
}
