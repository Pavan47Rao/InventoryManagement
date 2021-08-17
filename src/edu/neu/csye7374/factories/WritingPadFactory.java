package edu.neu.csye7374.factories;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.items.WritingPad;
import edu.neu.csye7374.model.Item;

public class WritingPadFactory extends AbstractItemFactory {

	@Override
	public Item getObject() {
		// TODO Auto-generated method stub
		return new WritingPad();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getObject().toString();
	}
}
