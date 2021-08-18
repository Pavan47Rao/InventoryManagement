package edu.neu.csye7374.api;

import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Order;
import edu.neu.csye7374.model.Supplier;

public interface SubjectAPI {
	
	void addObserver(ObserverAPI observer);
	
	void notifyObserver(Order order, InventoryManager inventoryManager, Supplier supplier);
	
}
