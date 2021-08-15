package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.IphoneFactory;


public class IphoneFactorySingleton {
	
	private static AbstractItemFactory iphoneInstance;
	
	private IphoneFactorySingleton() {
		iphoneInstance = null;
	}
	
	public static AbstractItemFactory getObject() {
		if(iphoneInstance == null) {
			iphoneInstance = new IphoneFactory();
		}
		return iphoneInstance;
	}

}
