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
	private Load loader;
	private Company company;


	public FileWriterReader() {
		this.saver = new Save(company);
		this.loader = new Load(company);

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
	
	




}
