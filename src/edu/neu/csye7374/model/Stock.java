package edu.neu.csye7374.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Stock implements Cloneable, Serializable{

	private int stockId;
	
	private List<Item> stockItems;
	
	private String stockType;//Electronics, Grocery etc
	
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
	
	public void addItemToStock(Item item) {
		this.getStockItems().add(item);
	}
	
	public void updateStockItem(Item item) {
		for(Item i: this.getStockItems()) {
			if(item.getItemId() == i.getItemId())
				i = item;
		}
	}
	
	public void deleteItemInStock(int id) {
		for(Item i: this.getStockItems()) {
			if(i.getItemId() == id)
				this.getStockItems().remove(i);
		}
	}
	
	public List<Item> searchItemInStockByName(String name) {
		List<Item> result = new ArrayList<>();
		for(Item i: this.getStockItems()) {
			if(i.getItemName().contains(name))
				result.add(i);
		}
		return result;
	}
	
	public List<Item> searchItemInStockByPrice(double price) {
		List<Item> result = new ArrayList<>();
		for(Item i: this.getStockItems()) {
			if(i.getItemPrice() == price)
				result.add(i);
		}
		return result;
	}
	
	public List<Item> searchItemInStockByDesc(String desc) {
		List<Item> result = new ArrayList<>();
		for(Item i: this.getStockItems()) {
			if(i.getItemDescription().contains(desc))
				result.add(i);
		}
		return result;
	}
	
	public Stock getMyClone() {
		Object obj = null;
		try {
			obj = this.clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Stock) obj;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getStockType();
	}
}
