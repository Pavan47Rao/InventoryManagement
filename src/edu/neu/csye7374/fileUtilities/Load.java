package edu.neu.csye7374.fileUtilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.model.Company;

import edu.neu.csye7374.model.Person;

public class Load {

	private String company_file = "company.ser";

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
	public List<Person> loadSuppliers() throws IOException, ClassNotFoundException {
		
		List<Person> persons = loadAllPersons();
		List<Person> suppliers = new ArrayList<>();
		System.out.println("Loading the suppliers...");
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getRoleId() == 3) {
				suppliers.add(persons.get(i));
				System.out.println(persons.get(i));
			}
		}

		return suppliers;
	}

	// load all HRs
	public List<Person> loadHR() throws IOException, ClassNotFoundException {
		
		List<Person> persons = loadAllPersons();
		List<Person> hr = new ArrayList<>();
		System.out.println("Loading the HRs...");
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getRoleId() == 2) {
				hr.add(persons.get(i));
				System.out.println(persons.get(i));
			}
		}

		return hr;
	}

	// load all managers
	public List<Person> loadManagers() throws IOException, ClassNotFoundException {
		
		List<Person> persons = loadAllPersons();
		List<Person> managers = new ArrayList<>();
		System.out.println("Loading the company managers...");
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getRoleId() == 1) {
				managers.add(persons.get(i));
				System.out.println(persons.get(i));
			}
		}

		return managers;
	}

	public Company loadAll() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(company_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println("Loading the company...");
		Company c = (Company) ois.readObject();
		System.out.println(c.getCompanyName());
		return c;

	}

}
