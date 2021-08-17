package edu.neu.csye7374.model;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager extends Person{
	
	List<Item> products = new ArrayList<Item>();
	
	List<Person> suppliers;
	
	List<Inventory> inventories;

	public List<Item> getProducts() {
		return products;
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
	
	public void addInventory(Inventory inventory) {
		this.getInventories().add(inventory);
	}
	
	public Inventory getInventory(int id) {
		for(Inventory i: this.getInventories())
			if(i.getInventoryId() == id)
				return i;
		return null;
	}
	
	public void deleteInventory(int id) {
		for(Inventory i: this.getInventories())
			if(i.getInventoryId() == id)
				this.getInventories().remove(i);
	}
	
	public void addItems(Item item) {
		this.getProducts().add(item);
	}
}
