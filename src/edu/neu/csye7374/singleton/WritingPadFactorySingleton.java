package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.WritingPadFactory;

public class WritingPadFactorySingleton {
	
	private static AbstractItemFactory writingPadInstance;
	
	private WritingPadFactorySingleton() {
		writingPadInstance = null;
	}
	
	public static AbstractItemFactory getObject() {
		if(writingPadInstance == null) {
			writingPadInstance = new WritingPadFactory();
		}
		return writingPadInstance;
	}

}
