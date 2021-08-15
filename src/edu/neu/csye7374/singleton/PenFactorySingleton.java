package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.PenFactory;


public class PenFactorySingleton {
	
	private static AbstractItemFactory penInstance;
	
	private PenFactorySingleton() {
		penInstance = null;
	}
	
	public static AbstractItemFactory getObject() {
		if(penInstance == null) {
			penInstance = new PenFactory();
		}
		return penInstance;
	}

}
