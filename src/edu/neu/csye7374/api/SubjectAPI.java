package edu.neu.csye7374.api;

import edu.neu.csye7374.model.Order;

public interface SubjectAPI {
	
	void addObserver(ObserverAPI observer);
	
	void notifyObserver(Order order);
	
}
