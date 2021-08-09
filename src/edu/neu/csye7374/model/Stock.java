package edu.neu.csye7374.model;

import java.util.List;

public class Stock {
	
	private int stockId;
	
	private List<Item> stockItems;
	
	private String stockType;
	
	private String stockDescription;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public List<Item> getStockItems() {
		return stockItems;
	}

	public void setStockItems(List<Item> stockItems) {
		this.stockItems = stockItems;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getStockDescription() {
		return stockDescription;
	}

	public void setStockDescription(String stockDescription) {
		this.stockDescription = stockDescription;
	}
	
	public Stock addItemToStock(Item item) {
		return null;
	}
	
	public void updateStock() {
		
	}
	
	public void deleteItemInStock(Item item) {
		
	}
	
	public Item searchItemInStock(String searchParam) {
		return null;
	}
}
