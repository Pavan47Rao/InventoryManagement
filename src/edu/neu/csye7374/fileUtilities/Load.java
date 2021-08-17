package edu.neu.csye7374.fileUtilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.model.Company;

import edu.neu.csye7374.model.Person;

public class Load {

	private Company company;
	private String company_file = "company.ser";

	public Load() {

	}

	public Load(Company company) {
		// TODO Auto-generated constructor stub
		this.company = company;
	}

	// Load all persons
	public List<Person> loadAllPersons() throws IOException, ClassNotFoundException {
		Company tempCompany = loadAll();

		return tempCompany.getPeople();
	}

	// ID=1 is Manager, ID=2 is HR, ID=3 is Supplier
	// load all suppliers
	public List<Person> loadSuppliers() throws IOException, ClassNotFoundException {
		List<Person> persons = loadAllPersons();
		List<Person> suppliers = new ArrayList<>();
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getRoleId() == 3) {
				suppliers.add(persons.get(i));
			}
		}

		return suppliers;
	}

	// load all HRs
	public List<Person> loadHR() throws IOException, ClassNotFoundException {
		List<Person> persons = loadAllPersons();
		List<Person> hr = new ArrayList<>();
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getRoleId() == 2) {
				hr.add(persons.get(i));
			}
		}

		return hr;
	}

	// load all managers
	public List<Person> loadManagers() throws IOException, ClassNotFoundException {
		List<Person> persons = loadAllPersons();
		List<Person> managers = new ArrayList<>();
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getRoleId() == 1) {
				managers.add(persons.get(i));
			}
		}

		return managers;
	}

	public Company loadAll() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(company_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		System.out.println("Loading the company...");
		this.company = (Company) ois.readObject();
		return this.company;

	}

}
