package edu.neu.csye7374.items;

import edu.neu.csye7374.api.AbstractItemAPI;
import edu.neu.csye7374.api.AbstractStockAPI;
import edu.neu.csye7374.model.Stock;

public class WritingPad extends AbstractItemAPI{
	
	private int itemId;
	private String itemName;
	private double itemPrice;
	private String itemDescription;
	private int itemQuantity;
	private Stock stock;
	
	
	/**
	 * Initialization block
	 */
	
	{
		this.itemId = 1;
		this.itemName = "Writing Pad";
		this.itemDescription = "Writing pad to support papers";
		this.itemPrice = 20.0;
		
		
	}


	@Override
	public int getItemId() {
		// TODO Auto-generated method stub
		return this.itemId;
	}


	@Override
	public int getItemQuantity() {
		// TODO Auto-generated method stub
		return this.itemQuantity;
	}


	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return this.itemName;
	}


	@Override
	public String getItemDescription() {
		// TODO Auto-generated method stub
		return this.itemDescription;
	}


	@Override
	public Stock getStock() {
		// TODO Auto-generated method stub
		return this.stock;
	}


	@Override
	public double getItemPrice() {
		// TODO Auto-generated method stub
		return this.itemPrice;
	}


	@Override
	public void setItemPrice(double itemPrice) {
		// TODO Auto-generated method stub
		this.itemPrice = itemPrice;
		
	}


	@Override
	public void setStock(Stock stock) {
		// TODO Auto-generated method stub
		this.stock = stock;
		
	}


	@Override
	public void setItemDescription(String itemDescription) {
		// TODO Auto-generated method stub
		this.itemDescription = itemDescription;
		
	}


	@Override
	public void setItemName(String itemName) {
		// TODO Auto-generated method stub
		this.itemName = itemName;
		
	}


	@Override
	public void setItemQuantity(int itemQuantity) {
		// TODO Auto-generated method stub
		this.itemQuantity = itemQuantity;
		
	}


	@Override
	public void setItemId(int itemId) {
		// TODO Auto-generated method stub
		this.itemId = itemId;
		
	}



}
