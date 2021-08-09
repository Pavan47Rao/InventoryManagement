package edu.neu.csye7374.model;

import java.util.List;

public class InventoryManager {
	
	List<Item> products;
	
	List<Person> suppliers;
	
	List<Inventory> inventories;

	public List<Item> getProducts() {
		return products;
	}

	public void setProducts(List<Item> products) {
		this.products = products;
	}

	public List<Person> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Person> suppliers) {
		this.suppliers = suppliers;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}
	
	
}
