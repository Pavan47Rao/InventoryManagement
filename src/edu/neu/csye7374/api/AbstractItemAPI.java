package edu.neu.csye7374.api;

import edu.neu.csye7374.model.Stock;

public abstract class AbstractItemAPI {
	/**
	 * 
	 * @return
	 */
	public abstract int getItemId();
	
	
	/**
	 * 
	 * @return
	 */
	public abstract int getItemQuantity();
	
	/**
	 * 
	 * @return
	 */
	
	public abstract String getItemName();
	
	/**
	 * 
	 * @return
	 */
	
	public abstract String getItemDescription();
	
	/**
	 * 
	 * @return
	 */
	
	public abstract Stock getStock();
	
	/**
	 * 
	 * @return
	 */
	public abstract double getItemPrice();
	
	/**
	 * 
	 * @param itemPrice
	 */
	public abstract void setItemPrice(double itemPrice);
	
	/**
	 * 
	 * @param stock
	 */
	public abstract void setStock(Stock stock);
	
	/**
	 * 
	 * @param itemDescription
	 */
	
	public abstract void setItemDescription(String itemDescription);
	
	/**
	 * 
	 * @param itemName
	 */
	
	public abstract void setItemName(String itemName);
	
	/**
	 * 
	 * @param itemQuantity
	 */
	
	public abstract void setItemQuantity(int itemQuantity);
	
	/**
	 * 
	 * @param itemId
	 */
	
	public abstract void setItemId(int itemId);
	
	
	

}
