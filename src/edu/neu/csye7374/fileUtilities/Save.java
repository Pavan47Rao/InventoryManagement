package edu.neu.csye7374.fileUtilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.model.Company;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Order;
import edu.neu.csye7374.model.Person;

public class Save {

	private String person_file = "persons.ser";
	private String order_file = "orders.ser";
	private String items_file = "items.ser";
	private String company_file = "company.ser";
	private Company company;

	public Save() {

	}

	public Save(Company company) {
		// TODO Auto-generated constructor stub
		this.company = company;
	}

	public void savePersons(List<Person> persons) throws IOException {

		FileOutputStream f = new FileOutputStream(new File(person_file));
		ObjectOutputStream o = new ObjectOutputStream(f);

		// Write objects to file
		o.writeObject(persons);

		o.close();
		f.close();
	}

	public void saveOrders(List<Order> orders) throws IOException {

		FileOutputStream f = new FileOutputStream(new File(order_file));
		ObjectOutputStream o = new ObjectOutputStream(f);

		// Write objects to file
		o.writeObject(orders);

		o.close();
		f.close();
	}

	public void saveItems(List<Item> items) throws IOException {

		FileOutputStream f = new FileOutputStream(new File(items_file));
		ObjectOutputStream o = new ObjectOutputStream(f);

		// Write objects to file
		o.writeObject(items);

		o.close();
		f.close();
	}

	public void saveAll() throws IOException {

		FileOutputStream f = new FileOutputStream(new File(company_file));
		ObjectOutputStream o = new ObjectOutputStream(f);

		// Write objects to file
		o.writeObject(company);

		o.close();
		f.close();

	}

}
