package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.AirpodsFactory;


public class AirpodsFactorySingleton {
	
	private static AbstractItemFactory airpodsInstance;
	
	private AirpodsFactorySingleton() {
		airpodsInstance = null;
	}
	
	public static AbstractItemFactory getObject() {
		if(airpodsInstance == null) {
			airpodsInstance = new AirpodsFactory();
		}
		return airpodsInstance;
	}

}
