package edu.neu.csye7374.factories;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.items.VRHeadset;
import edu.neu.csye7374.model.Item;

public class VRHeadsetFactory extends AbstractItemFactory {

	@Override
	public Item getObject() {
		// TODO Auto-generated method stub
		return new VRHeadset();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getObject().toString();
	}
}

