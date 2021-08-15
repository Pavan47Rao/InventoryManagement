package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.YogurtFactory;

public class YogurtFactorySingleton {
	
	private static AbstractItemFactory yogurtSingleton;
	
	private YogurtFactorySingleton() {
		yogurtSingleton = null;
	}
	
	public static AbstractItemFactory getObject() {
		if(yogurtSingleton == null) {
			yogurtSingleton = new YogurtFactory();
		}
		return yogurtSingleton;
	}

}
