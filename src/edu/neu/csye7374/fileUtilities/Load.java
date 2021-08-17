package edu.neu.csye7374.fileUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import edu.neu.csye7374.model.Person;

public class Load {

	private String csv;
	private String data;
	

	public Load(String csv) {
		this.csv = csv;
	}


	public void loadCSV() {
		List<String> strings = new ArrayList<String>();
		Scanner inLine = null;
		try {
			inLine = new Scanner(new BufferedReader(new FileReader(csv)));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		while (inLine.hasNextLine()) {
			strings.add(inLine.nextLine());
		}
		inLine.close();
	}
	
	public void loadObjects() throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(new File(data));
		ObjectInputStream oi = new ObjectInputStream(fi);
		Person pr1 = (Person) oi.readObject();
		System.out.println(pr1.toString());
		oi.close();
		fi.close();
	}
}
	
