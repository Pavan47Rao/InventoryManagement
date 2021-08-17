package edu.neu.csye7374.factories;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.items.Pencil;
import edu.neu.csye7374.model.Item;

public class PencilFactory extends AbstractItemFactory {

	@Override
	public Item getObject() {
		// TODO Auto-generated method stub
		return new Pencil();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getObject().toString();
	}
}

