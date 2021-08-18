package edu.neu.csye7374.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HR extends Person implements Serializable{

	public HR(int personId, int roleId, String firstName, String lastName, String emailId, Date dob, String address,
			Account account){
		super(personId, roleId, firstName, lastName, emailId, dob, address, account);
	}
	
	private List<InventoryManager> inventoryManagers;
	
	private List<Supplier> suppliers;

	public List<InventoryManager> getInventoryManagers() {
		return inventoryManagers;
	}

	public void setInventoryManagers(List<InventoryManager> inventoryManagers) {
		this.inventoryManagers = inventoryManagers;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	public void addInventoryManager(InventoryManager iManager) {
		this.getInventoryManagers().add(iManager);
	}
	
	public void addSupplier(Supplier supplier) {
		this.getSuppliers().add(supplier);
	}
	
	public InventoryManager findInventoryManager(int id) {
		for(InventoryManager im: this.getInventoryManagers())
			if(im.getPersonId() == id)
				return im;
		return null;
	}
	
	public Supplier findSupplier(int id) {
		for(Supplier s: this.getSuppliers())
			if(s.getPersonId() == id)
				return s;
		return null;
	}
	
	public InventoryManager updateIM(InventoryManager im) {
		for(InventoryManager i: this.getInventoryManagers())
			if(i.getPersonId() == im.getPersonId())
				i = im;
		return im;
	}
	
	public Supplier updateIM(Supplier su) {
		for(Supplier s: this.getSuppliers())
			if(s.getPersonId() == su.getPersonId())
				s = su;
		return su;
	}
	
	public void deleteIM(int id) {
		for(InventoryManager im: this.getInventoryManagers())
			if(im.getPersonId() == id)
				this.getInventoryManagers().remove(im);
	}
	
	public void deleteSupplier(int id) {
		for(Supplier s: this.getSuppliers())
			if(s.getPersonId() == id)
				this.getSuppliers().remove(s);
	}
	
}
