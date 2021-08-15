package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.CheeseFactory;

public class CheeseFactorySingleton {
	
	private static AbstractItemFactory cheeseInstance;
	
	private CheeseFactorySingleton() {
		cheeseInstance = null;
	}
	
	public static AbstractItemFactory getObject() {
		if(cheeseInstance == null) {
			cheeseInstance = new CheeseFactory();
		}
		return cheeseInstance;
	}

}