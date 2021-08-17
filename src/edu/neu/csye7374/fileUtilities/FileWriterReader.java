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

import edu.neu.csye7374.model.Person;

//a unified interface to a set of interfaces in a subsytem
public class FileWriterReader {

	private Save saver;
	private Load loader;
	private static final String data = "data.txt";
	private static List<Person> persons = new ArrayList<>();

	public FileWriterReader() {
		this.saver = new Save();
		this.loader = new Load();

	}

	public void saveAll() throws IOException {
		saver.saveAll();
	}

	public void loadAll() throws ClassNotFoundException, IOException {
		loader.loadAll();
	}
	
	public void loadPersons() throws ClassNotFoundException, IOException {
		loader.loadAllPersons();
	}

	public void loadSupplier() throws ClassNotFoundException, IOException {
		loader.loadSuppliers();
	}
	
	




}
