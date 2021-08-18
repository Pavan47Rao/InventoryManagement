package edu.neu.csye7374.stock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Stock;

public class Electronics extends Stock implements Serializable{
	
	public Electronics() {}
	private static final long serialVersionUID = -3590374434677802738L;
	private final static int STOCK_ID = 1;
	private final static String STOCK_TYPE = "Electronics";
	private final static String STOCK_DESCRIPTION = "This stock is meant to store Electronic gadgets";
	private List<Item> ELECTRONIC_TEMS = new ArrayList<>();
	
	{
		this.setStockId(STOCK_ID);
		this.setStockType(STOCK_TYPE);
		this.setStockDescription(STOCK_DESCRIPTION);
		this.setStockItems(ELECTRONIC_TEMS);
	}
	
	public void addItemToStock(Item item) {
		System.out.println("I am inside Electronics class addItemToStock and I should get executed not parent");
		ELECTRONIC_TEMS.add(item);
	}
}
