package edu.neu.csye7374.model;

public class Item {
	
	private int itemId;
	
	private String itemName;
	
	private double itemPrice;
	
	private String itemDescription;
	
	/**
	 * Pavan - Please add the stock over here for it to know which stock the item would be part of
	 * @return
	 */

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	
}
