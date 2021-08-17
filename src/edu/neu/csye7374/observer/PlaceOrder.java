package edu.neu.csye7374.observer;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.api.ObserverAPI;
import edu.neu.csye7374.api.SubjectAPI;
import edu.neu.csye7374.model.Order;

public class PlaceOrder implements SubjectAPI{

	List<ObserverAPI> observers = new ArrayList<>();
	
	@Override
	public void addObserver(ObserverAPI observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObserver(Order order) {
		for(ObserverAPI observer: observers) {
			observer.update(order);
		}
	}

}
