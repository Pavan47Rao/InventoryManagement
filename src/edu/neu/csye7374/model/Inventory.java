package edu.neu.csye7374.model;

import java.util.List;

public class Inventory {

	private int inventoryId;
	
	private String inventoryType;
	
	private int inventoryQuantity;
	
	private List<Stock> inventroyStock;

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public List<Stock> getInventroyStock() {
		return inventroyStock;
	}

	public void setInventroyStock(List<Stock> inventroyStock) {
		this.inventroyStock = inventroyStock;
	}
	
	public void addInventory(Inventory inventory) {
		
	}
	
	public Inventory getInventory(int id) {
		return null;
	}
	
	public void deleteInventory(int id) {
		
	}
}
