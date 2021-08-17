package edu.neu.csye7374.gui;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.AirpodsFactory;
import edu.neu.csye7374.gui.inventory_mgr.*;
import edu.neu.csye7374.gui.supplier.SupplierHomePage;
import edu.neu.csye7374.items.Airpods;
import edu.neu.csye7374.items.Pen;
import edu.neu.csye7374.model.Company;
import edu.neu.csye7374.model.Inventory;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Person;
import edu.neu.csye7374.singleton.AirpodsFactorySingleton;
import edu.neu.csye7374.singleton.CheeseFactorySingleton;
import edu.neu.csye7374.singleton.IphoneFactorySingleton;
import edu.neu.csye7374.singleton.MilkFactorySingleton;
import edu.neu.csye7374.singleton.PenFactorySingleton;
import edu.neu.csye7374.singleton.PencilFactorySingleton;
import edu.neu.csye7374.singleton.VRHeadsetFactorySingleton;
import edu.neu.csye7374.singleton.WritingPadFactorySingleton;
import edu.neu.csye7374.singleton.YogurtFactorySingleton;
import edu.neu.csye7374.stock.StockRepository;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.neu.csye7374.fileUtilities.FileWriterReader;
import edu.neu.csye7374.gui.inventory_mgr.InventoryManagerHomePage;
import edu.neu.csye7374.gui.supplier.SupplierHomePage;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Person;
import edu.neu.csye7374.stock.StockRepository;

public class MainFrame {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JButton loginBtn;
	private static List<Item> itemList;
	private static InventoryManager inventoryManager = new InventoryManager();
	private static Person loggedInPerson;
	private static Company company;

	public MainFrame() {
		frame = new JFrame();
		prepareGUI();
		init();
	}
	
	private void init() {
		StockRepository.loadItems();
		itemList = new ArrayList<Item>();
		company = new Company();
		
	}
	


	public static Company getCompany() {
		return company;
	}

	public static void setCompany(Company company) {
		MainFrame.company = company;
	}

	public static List<Item> getItemList() {
		return itemList;
	}

	public static void setItemList(List<Item> itemList) {
		MainFrame.itemList = itemList;
	}
	
	public static InventoryManager getInventoryManager() {
		return inventoryManager;
	}

	public static void setInventoryManager(InventoryManager inventoryManager) {
		MainFrame.inventoryManager = inventoryManager;
	}

	
	
	public static Person getLoggedInPerson() {
		return loggedInPerson;
	}

	public static void setLoggedInPerson(Person loggedInPerson) {
		MainFrame.loggedInPerson = loggedInPerson;
	}

	private void prepareGUI() {
		frame.setTitle("Inventory Management");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 20, 800, 500);
		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		
		
		JLabel headerLabel = new JLabel("Inventory Management");
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setBounds(101, 11, 504, 52);
		panel.add(headerLabel);
		
		JLabel userNameLabel = new JLabel("User Name");
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel.setBounds(172, 95, 156, 42);
		panel.add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(338, 94, 213, 45);
		panel.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(172, 162, 156, 42);
		panel.add(passwordLabel);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(338, 161, 213, 45);
		panel.add(passwordTextField);
		
		loginBtn = new JButton("Login");
		loginBtn.setDefaultCapable(false);
		loginBtn.setRequestFocusEnabled(false);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginBtn.setBounds(273, 228, 137, 42);
		panel.add(loginBtn);
		
		
		frame.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void loginActionPerformed(ActionEvent e) {
		System.out.println("Login button is clicked");
		System.out.println("Home page accordingly should open");
		String userName = userNameTextField.getText().toLowerCase();
		String password = passwordTextField.getPassword().toString();
		
		//inventory manager
		if(userNameTextField.getText().equalsIgnoreCase("aa") && passwordTextField.getText().equals("aa")) {
			frame.getContentPane().removeAll();
			new InventoryManagerHomePage(frame);
		}
		//Human resources
		if(userNameTextField.getText().equalsIgnoreCase("bb") && passwordTextField.getText().equals("bb")) {
			frame.getContentPane().removeAll();
			new HumanResourcesHomePage(frame);
		}
		//Supplier
		if(userNameTextField.getText().equalsIgnoreCase("cc") && passwordTextField.getText().equals("cc")) {
			frame.getContentPane().removeAll();
			new SupplierHomePage(frame);
		}
		
		FileWriterReader fwr = new FileWriterReader();
		try {
			List<Person> staff = fwr.loadPersons();
			for(Person person: staff) {
				if(person.getAccount().getUserName().equals(userName) && person.getAccount().getPassword().equals(password)) {
					switch(person.getRoleId()) {
					case 1:
						frame.getContentPane().removeAll();
						new InventoryManagerHomePage(frame);
						break;
					case 2:
						frame.getContentPane().removeAll();
						new SupplierHomePage(frame);
						break;
					case 3:
						frame.getContentPane().removeAll();
						new HumanResourcesHomePage(frame);
						break;
					}
					loggedInPerson = person;
				}
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void demo() {
		new MainFrame();
	}
}
