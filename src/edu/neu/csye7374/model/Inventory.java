package edu.neu.csye7374.model;

import java.io.Serializable;
import java.util.List;

import edu.neu.csye7374.stock.StockRepository;

public class Inventory implements Serializable {

	private int inventoryId;
	
	private String inventoryName;
	
	private List<Stock> inventroyStock;
	
	private StockRepository stockRepository;
	
	{
		this.inventoryId = 1;
		this.inventoryName = "CSYE7374 Inventory";
	}

	public StockRepository getStockRepository() {
		return stockRepository;
	}

	public void setStockRepository(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

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
