package edu.neu.csye7374.adapter;

import java.util.List;

import edu.neu.csye7374.api.ItemBillingAPI;
import edu.neu.csye7374.api.CalculateAPI.OPERATION;
import edu.neu.csye7374.model.Item;

public class CalculatorAdapter implements ItemBillingAPI{

	private final Calculator calc;
	private double price;
	private int quantity;
	
	public CalculatorAdapter(Calculator calc) {
		super();
		this.calc = calc;
		this.price = 0;
		this.quantity = 0;
	}
	
	@Override
	public double updatePrice(List<Item> billItems) {
		for(Item item:billItems) {
			price = this.calc.operation(OPERATION.ADD,price,item.getItemPrice());
		}
		return price;
	}

	@Override
	public int updateQuantity(List<Item> billItems) {
		for(Item item:billItems) {
			quantity = (int)this.calc.operation(OPERATION.ADD,price,item.getItemQuantity());
		}
		return quantity;
	}

}
