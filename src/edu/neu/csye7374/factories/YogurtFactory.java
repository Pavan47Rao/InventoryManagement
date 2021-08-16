package edu.neu.csye7374.factories;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.items.Yogurt;
import edu.neu.csye7374.model.Item;

public class YogurtFactory extends AbstractItemFactory {

	@Override
	public Item getObject() {
		// TODO Auto-generated method stub
		return new Yogurt();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getObject().toString();
	}
}

