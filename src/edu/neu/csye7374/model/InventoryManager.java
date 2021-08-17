package edu.neu.csye7374.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class InventoryManager extends Person{
	
	List<Item> items = new ArrayList<Item>();
	
	List<Inventory> inventories;
	
	List<Order> orders;
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Item> getItems() {
		return items;
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
		this.getItems().add(item);
	}
	
	public void deleteItems(int id) {
		for(ListIterator<Item> itr = this.getItems().listIterator(); itr.hasNext();) {
			Item i = itr.next();
			if(i.getItemId() == id) {
				itr.remove();
			}
		}
	}
}
