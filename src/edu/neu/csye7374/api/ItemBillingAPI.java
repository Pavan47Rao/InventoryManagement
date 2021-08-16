package edu.neu.csye7374.api;

import java.util.List;

import edu.neu.csye7374.model.Item;

public interface ItemBillingAPI {
	double updatePrice(List<Item> billItem);
	int updateQuantity(List<Item> billItem);
}
