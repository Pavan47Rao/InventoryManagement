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

import edu.neu.csye7374.model.Order;
import edu.neu.csye7374.model.Person;

public class Load {

	private String person_file = "persons.ser";
	private String order_file = "orders.ser";

	public Load() {
		
	}

	@SuppressWarnings("unchecked")
	public List<Person> loadAllPersons() throws IOException, ClassNotFoundException {
		List<Person> persons = new ArrayList<>();
		FileInputStream fis = new FileInputStream(person_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		persons = (List<Person>) ois.readObject();

		for (int i = 0; i < persons.size(); i++) {
			System.out.println(persons.get(i));
		}

		return persons;
	}

	@SuppressWarnings("unchecked")
	public List<Person> loadSuppliers() throws IOException, ClassNotFoundException {
		List<Person> persons = loadAllPersons();
		List<Person> suppliers = new ArrayList<>();
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getAccount().getStatus() == "Supplier") {
				suppliers.add(persons.get(i));
			}
		}

		return suppliers;
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> loadHR() throws IOException, ClassNotFoundException {
		List<Person> persons = loadAllPersons();
		List<Person> hr = new ArrayList<>();
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getAccount().getStatus() == "HR") {
				hr.add(persons.get(i));
			}
		}
		
		return hr;
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> loadAllOrders() throws IOException, ClassNotFoundException {
		List<Order> orders = new ArrayList<>();
		FileInputStream fis = new FileInputStream(order_file);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(fis);

		orders = (List<Order>) ois.readObject();

		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i));
		}

		return orders;
	}

	public void loadAll() throws IOException, ClassNotFoundException {

	}

}
