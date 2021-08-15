package edu.neu.csye7374.factories;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.items.WritingPad;
import edu.neu.csye7374.model.Item;

public class VRHeadsetFactory extends AbstractItemFactory {

	@Override
	public Item getObject() {
		// TODO Auto-generated method stub
		return new WritingPad();
	}

}

