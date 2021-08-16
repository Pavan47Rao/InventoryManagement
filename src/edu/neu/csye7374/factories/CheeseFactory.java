package edu.neu.csye7374.factories;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.items.Cheese;
import edu.neu.csye7374.model.Item;

public class CheeseFactory extends AbstractItemFactory {

	@Override
	public Item getObject() {
		// TODO Auto-generated method stub
		return new Cheese();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getObject().toString();
	}

}
