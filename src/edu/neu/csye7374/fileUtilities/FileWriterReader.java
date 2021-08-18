package edu.neu.csye7374.fileUtilities;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.neu.csye7374.model.Company;
import edu.neu.csye7374.model.HR;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Person;
<<<<<<< HEAD
import edu.neu.csye7374.model.Supplier;
=======
import edu.neu.csye7374.model.Stock;
import edu.neu.csye7374.stock.StockRepository;
>>>>>>> 6dc9dd7a4be5341e0bc4e6ca1f4382cf084dbe9c

//a unified interface to a set of interfaces in a subsytem
public class FileWriterReader {

	private Save saver;
	private Load loader = new Load();
	private Company company;

	// when there is no files. Need to initialize a company and people 
	public FileWriterReader(Company company) throws ClassNotFoundException, IOException {
		this.company = company;
		this.saver = new Save(company);

	}
	
	//when there are files written already
	public FileWriterReader() throws ClassNotFoundException, IOException {
		this.company = loadAll();
				
		
	}

	public void saveAll() throws IOException {
		saver.saveAll();
	}
	

	public Company loadAll() throws ClassNotFoundException, IOException {
		return loader.loadAll();
	}
	
	
	public List<Person> loadPersons() throws ClassNotFoundException, IOException {
		return loader.loadAllPersons();
	}

	public List<Supplier> loadSupplier() throws ClassNotFoundException, IOException {
		return loader.loadSuppliers();
	}
	
	public List<InventoryManager> loadManagers() throws ClassNotFoundException, IOException {
		return loader.loadManagers();
	}
	
	public List<HR> loadHRs() throws ClassNotFoundException, IOException {
		return loader.loadHR();
	}
	
	
	public Map<String, Stock> loadStockRepo () throws ClassNotFoundException, IOException {
		return loader.loadStockRepo();
	}
	
	
	public void saveStockRepo () throws ClassNotFoundException, IOException {
		saver.saveStockRepo();
		
	}
	




}
