package edu.neu.csye7374.model;

import java.util.List;

public class Inventory {

	private int inventoryId;
	
	private String inventoryType; // remove this - change this to inventory name
	
	private int inventoryQuantity; // this needs to go to the item quantity
	
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
	
}
