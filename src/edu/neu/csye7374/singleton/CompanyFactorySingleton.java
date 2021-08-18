package edu.neu.csye7374.singleton;

import edu.neu.csye7374.api.AbstractCompanyFactory;
import edu.neu.csye7374.factories.CompanyFactory;

public class CompanyFactorySingleton {
	
	private static AbstractCompanyFactory companyInstance;
	
	private CompanyFactorySingleton() {
		companyInstance = null;
	}
	
	public static AbstractCompanyFactory getCompanyObject() {
		if(companyInstance == null) {
			companyInstance = new CompanyFactory();
		} 
		return companyInstance;
	}

}
