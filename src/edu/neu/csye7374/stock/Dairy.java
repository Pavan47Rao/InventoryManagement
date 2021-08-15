package edu.neu.csye7374.stock;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Stock;

public class Dairy extends Stock {

	public Dairy() {}
	
	private final static int STOCK_ID = 3;
	private final static String STOCK_TYPE = "Dairy";
	private final static String STOCK_DESCRIPTION = "This stock is meant to store perishable Dairy products";
	private List<Item> DAIRY_TEMS = new ArrayList<>();
	
	{
		this.setStockId(STOCK_ID);
		this.setStockType(STOCK_TYPE);
		this.setStockDescription(STOCK_DESCRIPTION);
		this.setStockItems(DAIRY_TEMS);
	}
}
