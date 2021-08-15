package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.VRHeadsetFactory;

public class VRHeadsetFactorySingleton {
	
	private static AbstractItemFactory vrHeadSetInstance;
	
	private VRHeadsetFactorySingleton() {
		vrHeadSetInstance = null;
	}
	
	public static AbstractItemFactory getObject() {
		if(vrHeadSetInstance == null) {
			vrHeadSetInstance = new VRHeadsetFactory();
		}
		return vrHeadSetInstance;
	}

}
