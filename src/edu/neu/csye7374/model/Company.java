package edu.neu.csye7374.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.fileUtilities.FileWriterReader;

public class Company implements Serializable{

	private String companyName;
	
	private int companyId;
	
	private String address;
	
	private Inventory inventory;
	
	private List<Person> people;
	
	private List<InventoryManager> managers;
	
	private List<Supplier> suppliers;
	
	private List<HR> hrs;

	
	public Company() {
		// TODO Auto-generated constructor stub
		inventory = new Inventory();
		this.people = new ArrayList<Person>();
		this.managers = new ArrayList<>();
		this.suppliers = new ArrayList<>();
		this.hrs = new ArrayList<>();
	}
	
	public List<InventoryManager> getManagers() {
		return managers;
	}
	
	public void setManagers(List<InventoryManager> managers) {
		this.managers = managers;
	}
	
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	public List<HR> getHrs() {
		return hrs;
	}

	public void setHrs(List<HR> hrs) {
		this.hrs = hrs;
	}

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
