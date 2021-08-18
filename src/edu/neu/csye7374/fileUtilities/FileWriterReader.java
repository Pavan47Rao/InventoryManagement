package edu.neu.csye7374.fileUtilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.model.Company;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Order;
import edu.neu.csye7374.model.Person;

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

	public List<Person> loadSupplier() throws ClassNotFoundException, IOException {
		return loader.loadSuppliers();
	}
	
	public List<Person> loadManagers() throws ClassNotFoundException, IOException {
		return loader.loadManagers();
	}
	
	public List<Person> loadHRs() throws ClassNotFoundException, IOException {
		return loader.loadHR();
	}
	
	




}
