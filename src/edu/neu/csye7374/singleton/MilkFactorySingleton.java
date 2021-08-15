package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.MilkFactory;


public class MilkFactorySingleton {
	
	private static AbstractItemFactory milkInstance;
	
	private MilkFactorySingleton() {
		milkInstance = null;
	}
	
	public static AbstractItemFactory getObject() {
		if(milkInstance == null) {
			milkInstance = new MilkFactory();
		}
		return milkInstance;
	}

}
