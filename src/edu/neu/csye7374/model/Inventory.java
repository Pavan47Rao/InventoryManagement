package edu.neu.csye7374.model;

import java.util.List;

public class Inventory {

	private int inventoryId;
	
	private String inventoryName;
	
	private List<Stock> inventroyStock;

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryType(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public List<Stock> getInventroyStock() {
		return inventroyStock;
	}

	public void setInventroyStock(List<Stock> inventroyStock) {
		this.inventroyStock = inventroyStock;
	}
	
}
