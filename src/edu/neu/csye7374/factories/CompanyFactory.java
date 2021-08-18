package edu.neu.csye7374.factories;

import edu.neu.csye7374.api.AbstractCompanyFactory;
import edu.neu.csye7374.model.Company;

public class CompanyFactory extends AbstractCompanyFactory {

	@Override
	public Company getCompanyObject() {
		// TODO Auto-generated method stub
		return new Company();
	}
	
	

}
