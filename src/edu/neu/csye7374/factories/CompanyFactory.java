package edu.neu.csye7374.factories;

import java.io.IOException;

import edu.neu.csye7374.api.AbstractCompanyFactory;
import edu.neu.csye7374.fileUtilities.FileWriterReader;
import edu.neu.csye7374.model.Company;

public class CompanyFactory extends AbstractCompanyFactory {

	@Override
	public Company getCompanyObject() {
		// TODO Auto-generated method stub
		FileWriterReader fu;
		try {
			fu = new FileWriterReader();
			return fu.loadAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}

