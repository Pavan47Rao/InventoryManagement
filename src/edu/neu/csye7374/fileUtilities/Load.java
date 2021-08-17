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

import edu.neu.csye7374.model.Company;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Order;
import edu.neu.csye7374.model.Person;

public class Load {

	private Company company;
	private String person_file = "persons.ser";
	private String order_file = "orders.ser";
	private String items_file = "items.ser";
	private String company_file = "company.ser";

	public Load() {
		
	}

	public Load(Company company) {
		// TODO Auto-generated constructor stub
		this.company=company;
	}

	// Load items 
	@SuppressWarnings("unchecked")
	public List<Item> loadAllItems() throws IOException, ClassNotFoundException {
		List<Item> items = new ArrayList<>();
		FileInputStream fis = new FileInputStream(items_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		items = (List<Item>) ois.readObject();
		
		System.out.println("Start loading items...");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i));
		}
		
		this.company.setItems(items);
		return items;
	}
	
	// Load all persons
	@SuppressWarnings("unchecked")
	public List<Person> loadAllPersons() throws IOException, ClassNotFoundException {
		List<Person> persons = new ArrayList<>();
		FileInputStream fis = new FileInputStream(person_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		persons = (List<Person>) ois.readObject();
		System.out.println("Start loading persons...");
		for (int i = 0; i < persons.size(); i++) {
			System.out.println(persons.get(i));
		}

		this.company.setPeople(persons);
		return persons;
	}

	//ID=1 is Manager, ID=2 is HR, ID=3 is Supplier
	// load all suppliers 
	@SuppressWarnings("unchecked")
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
	
	//load all HRs
	@SuppressWarnings("unchecked")
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
	
	//load all managers 
	@SuppressWarnings("unchecked")
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
	
	//load all orders 
	@SuppressWarnings("unchecked")
	public List<Order> loadAllOrders() throws IOException, ClassNotFoundException {
		List<Order> orders = new ArrayList<>();
		FileInputStream fis = new FileInputStream(order_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		orders = (List<Order>) ois.readObject();

		System.out.println("Start loading orders...");
		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i));
		}

		this.company.setOrders(orders);
		return orders;
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
