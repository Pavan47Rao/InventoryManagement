package edu.neu.csye7374.model;



public class Item {
	
	private int itemId;
	private String itemName;
	private double itemPrice;
	private String itemDescription;
	private int itemQuantity;
	private Stock stock;
	
	
	
	public int getItemId() {
		// TODO Auto-generated method stub
		return itemId;
	}
	
	public int getItemQuantity() {
		// TODO Auto-generated method stub
		return itemQuantity;
	}

	public String getItemName() {
		// TODO Auto-generated method stub
		return itemName;
	}

	public String getItemDescription() {
		// TODO Auto-generated method stub
		return itemDescription;
	}
	
	public Stock getStock() {
		// TODO Auto-generated method stub
		return stock;
	}
	

	public double getItemPrice() {
		// TODO Auto-generated method stub
		return itemPrice;
	}
	
	
	
	public void setStock(Stock stock) {
		// TODO Auto-generated method stub
		this.stock = stock;
		
	}
	
	public void setItemDescription(String itemDescription) {
		// TODO Auto-generated method stub
		this.itemDescription = itemDescription;
		
	}
	
	public void setItemName(String itemName) {
		// TODO Auto-generated method stub
		this.itemName = itemName;
		
	}

	public void setItemQuantity(int itemQuantity) {
		// TODO Auto-generated method stub
		this.itemQuantity = itemQuantity;
		
	}
	
	public void setItemId(int itemId) {
		// TODO Auto-generated method stub
		this.itemId = itemId;
		
	}
	
	
	public void setItemPrice(double itemPrice) {
		// TODO Auto-generated method stub
		this.itemPrice = itemPrice;
		
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("To string method of item");
		return getItemName();
	}
	
}
