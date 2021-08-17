package edu.neu.csye7374.gui;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.AirpodsFactory;
import edu.neu.csye7374.gui.inventory_mgr.*;
import edu.neu.csye7374.gui.supplier.SupplierHomePage;
import edu.neu.csye7374.items.Airpods;
import edu.neu.csye7374.items.Pen;
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

public class MainFrame {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JButton loginBtn;
	private static List<Item> itemList;
	private static InventoryManager inventoryManager = new InventoryManager();
	private static Person loggedInPerson;


	



	public MainFrame() {
		frame = new JFrame();
		prepareGUI();
		init();
	}
	
	private void init() {
		StockRepository.loadItems();
		itemList = new ArrayList<Item>();
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
		
		
		
		
	}
	
	public static void demo() {
		new MainFrame();
	}
}
