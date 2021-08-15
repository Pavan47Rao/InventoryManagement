package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.PencilFactory;

public class PencilFactorySingleton {
	
	private static AbstractItemFactory pencilInstance;
	
	private PencilFactorySingleton() {
		pencilInstance = null;
	}
	
	public static AbstractItemFactory getObject() {
		if(pencilInstance == null) {
			pencilInstance = new PencilFactory();
		}
		return pencilInstance;
	}

}