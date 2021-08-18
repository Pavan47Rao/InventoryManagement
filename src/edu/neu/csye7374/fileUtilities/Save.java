package edu.neu.csye7374.fileUtilities;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;

import edu.neu.csye7374.model.Company;

public class Save {

	private String company_file = "company.ser";
	private String stock_repo_file = "stock_repo_file.ser";
	private Company company;

	public Save(Company company) {
		// TODO Auto-generated constructor stub
		this.company = company;
	}

	public void saveAll() throws IOException {

		FileOutputStream f = new FileOutputStream(new File(company_file));
		ObjectOutputStream o = new ObjectOutputStream(f);

		// Write objects to file
		o.writeObject(this.company);

		o.close();
		f.close();

	}
	public void saveStockRepo() throws IOException {
		
		FileOutputStream f = new FileOutputStream(new File(stock_repo_file));
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		// Write objects to file
		o.writeObject(this.company.getInventory().getStockRepository());
		
		o.close();
		f.close();
		
	}

}
