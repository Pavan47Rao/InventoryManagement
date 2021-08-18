package edu.neu.csye7374.stock;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import edu.neu.csye7374.fileUtilities.FileWriterReader;
import edu.neu.csye7374.model.Stock;

public class StockRepository implements Serializable{
	
	public static Map<String, Stock> stockMap  = new HashMap<>();
	
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
	    
	    
	    FileWriterReader fileUtil;
		try {
			fileUtil = new FileWriterReader();
			Map<String, Stock> stock_map = fileUtil.loadStockRepo();
			if(!stock_map.values().isEmpty()) {
				stockMap = stock_map;
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
}
