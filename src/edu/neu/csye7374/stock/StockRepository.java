package edu.neu.csye7374.stock;

import java.util.HashMap;
import java.util.Map;

import edu.neu.csye7374.model.Stock;

public class StockRepository {
	
	private static Map<String, Stock> stockMap  = new HashMap<>();
	
	public static Stock getStock(String itemId) {
		Stock cachedStock = stockMap.get(itemId);
	    return (Stock) cachedStock.getMyClone();
	}
	
	public static void loadItems() {
		Electronics electronics = new Electronics();
		stockMap.put("Electronics",electronics);

		Stationary stationary = new Stationary();
		stockMap.put("Stationary",stationary);
	      
	    Dairy dairy = new Dairy();
	    stockMap.put("Dairy",dairy);
	}
	
}
