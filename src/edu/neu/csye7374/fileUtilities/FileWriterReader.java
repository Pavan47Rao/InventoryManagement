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
		this.saver = new Save(data);
		this.loader = new Load(data);

	}

	public void save() throws IOException {
		saver.save();

	}

	public void load() {
		loader.loadCSV();
	}

	public void refresh() throws IOException {
		saver.save();
		loader.loadCSV();
	}

	public static void demo() throws IOException {

		FileWriterReader fileUti = new FileWriterReader();


		fileUti.save();

		// Read objects
		fileUti.load();

	}

}
