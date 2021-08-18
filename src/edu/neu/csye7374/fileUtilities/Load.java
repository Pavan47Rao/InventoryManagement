package edu.neu.csye7374.fileUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;

import edu.neu.csye7374.model.Company;
import edu.neu.csye7374.model.HR;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Person;
import edu.neu.csye7374.model.Supplier;
import edu.neu.csye7374.model.Stock;
import edu.neu.csye7374.singleton.CompanyFactorySingleton;
import edu.neu.csye7374.stock.StockRepository;

public class Load {

	private String company_file = "company.ser";
	private String stock_repo_file = "stock_repo_file.ser";
	
	
	public Load() {

	}


	// Load all persons
	public List<Person> loadAllPersons() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(company_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println("Loading the company personnal...");
		Company c = (Company) ois.readObject();
		return c.getPeople();
	}

	// ID=1 is Manager, ID=2 is HR, ID=3 is Supplier
	// load all suppliers
	public List<Supplier> loadSuppliers() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(company_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println("Loading the company personnal...");
		Company c = (Company) ois.readObject();
		return c.getSuppliers();
	}

	// load all HRs
	public List<HR> loadHR() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(company_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println("Loading the company personnal...");
		Company c = (Company) ois.readObject();
		return c.getHrs();
	}

	// load all managers
	public List<InventoryManager> loadManagers() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(company_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println("Loading the company personnal...");
		Company c = (Company) ois.readObject();
		return c.getManagers();
	}

	public Company loadAll() throws IOException, ClassNotFoundException {
		/**
		 * We need to check if the company instance is present inside the file or not
		 * if it is present then we need to call that instance
		 * other wise we need to create a new instance first time
		 * 
		 */

		FileInputStream fis = new FileInputStream(company_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println("Loading the company...");
		//Company c = (Company) ois.readObject();
		

		return (Company) ois.readObject();

	}

	public Map<String, Stock> loadStockRepo() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(stock_repo_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println("Loading the stock repo...");
		return (Map<String, Stock>) ois.readObject();
	}

}
