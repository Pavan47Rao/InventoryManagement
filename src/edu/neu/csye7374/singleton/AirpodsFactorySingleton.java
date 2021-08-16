package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.AirpodsFactory;


public class AirpodsFactorySingleton {
	
	private static AbstractItemFactory airpodsInstance = new AirpodsFactory();
	
	private AirpodsFactorySingleton() {
	
	}
	
	public static AbstractItemFactory getObject() {
		return airpodsInstance;
	}

}
