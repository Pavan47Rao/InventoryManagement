package edu.neu.csye7374.stock;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Stock;

public class Stationary extends Stock {
	
	public Stationary() {}
	
	private final static int STOCK_ID = 2;
	private final static String STOCK_TYPE = "Stationary";
	private final static String STOCK_DESCRIPTION = "This stock is meant to store Stationary items";
	private List<Item> STATIONARY_TEMS = new ArrayList<>();
	
	{
		this.setStockId(STOCK_ID);
		this.setStockType(STOCK_TYPE);
		this.setStockDescription(STOCK_DESCRIPTION);
		this.setStockItems(STATIONARY_TEMS);
	}
}
