package edu.neu.csye7374.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Supplier extends Person implements Serializable{
	
	private static final long serialVersionUID = -4938897871428671084L;
	
	public Supplier(int personId, int roleId, String firstName, String lastName, String emailId, Date dob, String address,
			Account account){
		super(personId, roleId, firstName, lastName, emailId, dob, address, account);
	}

	List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
