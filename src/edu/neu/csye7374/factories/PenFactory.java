package edu.neu.csye7374.factories;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.items.Pen;
import edu.neu.csye7374.model.Item;

public class PenFactory extends AbstractItemFactory {

	@Override
	public Item getObject() {
		// TODO Auto-generated method stub
		return new Pen();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getObject().toString();
	}
}

