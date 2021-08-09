package edu.neu.csye7374.model;

import java.util.List;

public class Supplier extends Person{

	List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
