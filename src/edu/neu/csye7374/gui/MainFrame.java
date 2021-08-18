package edu.neu.csye7374.gui;

import edu.neu.csye7374.api.AbstractCompanyFactory;
import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.AirpodsFactory;
import edu.neu.csye7374.gui.inventory_mgr.*;
import edu.neu.csye7374.gui.supplier.SupplierHomePage;
import edu.neu.csye7374.items.Airpods;
import edu.neu.csye7374.items.Pen;
import edu.neu.csye7374.model.Company;
import edu.neu.csye7374.model.HR;
import edu.neu.csye7374.model.Inventory;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Person;
import edu.neu.csye7374.model.Supplier;
import edu.neu.csye7374.singleton.AirpodsFactorySingleton;
import edu.neu.csye7374.singleton.CheeseFactorySingleton;
import edu.neu.csye7374.singleton.CompanyFactorySingleton;
import edu.neu.csye7374.singleton.IphoneFactorySingleton;
import edu.neu.csye7374.singleton.MilkFactorySingleton;
import edu.neu.csye7374.singleton.PenFactorySingleton;
import edu.neu.csye7374.singleton.PencilFactorySingleton;
import edu.neu.csye7374.singleton.VRHeadsetFactorySingleton;
import edu.neu.csye7374.singleton.WritingPadFactorySingleton;
import edu.neu.csye7374.singleton.YogurtFactorySingleton;
import edu.neu.csye7374.state.LoggedInState;
import edu.neu.csye7374.state.LoggedOutState;
import edu.neu.csye7374.state.StateAPI;
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
import javax.swing.JOptionPane;
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
	private static Person loggedInPerson;
	private static Company company;
	private JButton resetPwdButton;

	
	
	private LoggedInState loggedIn = new LoggedInState();
	private LoggedOutState loggedOut = new LoggedOutState();
	private StateAPI state = loggedOut;
	

	public StateAPI getState() {
		return state;
	}

	public void setState(StateAPI state) {
		this.state = state;
	}

	public MainFrame() throws ClassNotFoundException, IOException {
		frame = new JFrame();
		prepareGUI();
		init();
	}
	
	private void init() throws ClassNotFoundException, IOException {
		StockRepository.loadItems();
		itemList = new ArrayList<Item>();

		AbstractCompanyFactory companyFactory = CompanyFactorySingleton.getCompanyObject();
		company = companyFactory.getCompanyObject();
		List<InventoryManager> managers = new ArrayList<>();
		List<HR> hrs = new ArrayList<>();
		List<Supplier> suppliers = new ArrayList<>();
	//	company.setManagers(managers);
	//	company.setHrs(hrs);
	//	company.setSuppliers(suppliers);

		//FileWriterReader fileUtil1 = new FileWriterReader(company);
		//fileUtil1.saveAll();
		
		FileWriterReader fileUtil = new FileWriterReader();
		fileUtil.loadAll();
		fileUtil.loadStockRepo();
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
		frame.getContentPane().add(panel);
		
		
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
				try {
					loginActionPerformed(e);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginBtn.setBounds(273, 228, 137, 42);
		panel.add(loginBtn);
		
		resetPwdButton = new JButton("Forgot Password? Reset Here");
		resetPwdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new ResetPasswordPage(frame);
			}
		});
		resetPwdButton.setBounds(236, 303, 220, 42);
		panel.add(resetPwdButton);
		
		
		frame.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void loginActionPerformed(ActionEvent e) throws ClassNotFoundException, IOException {
		System.out.println("Login button is clicked");
		System.out.println("Home page accordingly should open");
		String userName = userNameTextField.getText().toLowerCase();
		String password = new String(passwordTextField.getPassword());
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
		boolean foundUser = false;
		try {
			List<InventoryManager> managers = fwr.loadManagers();
			List<Supplier> suppliers = fwr.loadSupplier();
			List<HR> hrs = fwr.loadHRs();
			for(InventoryManager person: managers) {
				if(person.getAccount().getUserName().equals(userName) && person.getAccount().getPassword().equals(password)) {
					foundUser = true;
						frame.getContentPane().removeAll();
						new InventoryManagerHomePage(frame);
					
						
					}
					loggedInPerson = person;
					this.state = loggedIn;
			}
			
			if(!foundUser) {
				
				for(Supplier person: suppliers) {
					if(person.getAccount().getUserName().equals(userName) && person.getAccount().getPassword().equals(password)) {
						foundUser = true;
							frame.getContentPane().removeAll();
							new SupplierHomePage(frame);
						
							
						}
						loggedInPerson = person;
						this.state = loggedIn;
				}

			}
	
			if(!foundUser) {
				for(HR person: hrs) {
					if(person.getAccount().getUserName().equals(userName) && person.getAccount().getPassword().equals(password)) {
						foundUser = true;
							frame.getContentPane().removeAll();
							new HumanResourcesHomePage(frame);
						
							
						}
						loggedInPerson = person;
						this.state = loggedIn;
				}
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(!foundUser)
			JOptionPane.showMessageDialog(panel, "Incorrect credentials!");
	}
	
	public static void demo() throws ClassNotFoundException, IOException {
		new MainFrame();
	}
}
