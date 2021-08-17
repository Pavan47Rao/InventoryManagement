package edu.neu.csye7374.observer;

import edu.neu.csye7374.api.ObserverAPI;
import edu.neu.csye7374.api.SubjectAPI;
import edu.neu.csye7374.model.Order;

public class UpdateOrderStatus implements ObserverAPI{

	SubjectAPI observable;
	
	public UpdateOrderStatus(SubjectAPI observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void update(Order order) {
		// update order status of InventoryManager
		// update order status of Supplier
		// send email
		if(order.getStatus().equals("placed")) {
			
		}
		else if(order.getStatus().equals("approved")) {
			
		}
	}

}
