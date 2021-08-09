package edu.neu.csye7374.model;

import java.util.List;

public class HR extends Person{

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
	
	public void addPerson(Person person) {
		
	}
	
	public Person findPerson(int id) {
		return null;
	}
	
	public Person updatePerson(Person person) {
		return null;
	}
	
	public void deletePerson(int id) {
		
	}
	
}
