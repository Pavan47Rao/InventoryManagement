package edu.neu.csye7374.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.neu.csye7374.fileUtilities.FileWriterReader;
import edu.neu.csye7374.model.Account;
import edu.neu.csye7374.model.HR;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Person;
import edu.neu.csye7374.model.Supplier;

public class HumanResourceAddUserPage {

	private JFrame frame;
	private JPanel panel;
	private JTextField textField_ID;
	private JTextField textField_firstName;
	private JTextField textField_lastname;
	private JTextField textField_email;
	private JTextField textField_addr;
	private JTextField textField_dob;
	private JPasswordField passwordField;
	private JComboBox comboBox;

	public HumanResourceAddUserPage(JFrame frame) {
		this.frame = frame;
		prepareGUI();

	}

	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(239, 44, 98, 32);
		panel.add(lblNewLabel);

		textField_ID = new JTextField();
		textField_ID.setBounds(378, 44, 217, 32);
		panel.add(textField_ID);
		textField_ID.setColumns(10);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(239, 87, 98, 32);
		panel.add(lblRole);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(239, 130, 98, 32);
		panel.add(lblFirstName);

		textField_firstName = new JTextField();
		textField_firstName.setColumns(10);
		textField_firstName.setBounds(378, 130, 217, 32);
		panel.add(textField_firstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(239, 177, 98, 32);
		panel.add(lblLastName);

		textField_lastname = new JTextField();
		textField_lastname.setColumns(10);
		textField_lastname.setBounds(378, 177, 217, 32);
		panel.add(textField_lastname);

		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setBounds(239, 220, 98, 32);
		panel.add(lblEmailId);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(378, 220, 217, 32);
		panel.add(textField_email);

		JLabel lblDateOfBirth = new JLabel("Date of Birth (yyyy-mm-dd)");
		lblDateOfBirth.setBounds(239, 306, 98, 32);
		panel.add(lblDateOfBirth);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(239, 349, 98, 32);
		panel.add(lblAddress);

		textField_addr = new JTextField();
		textField_addr.setColumns(10);
		textField_addr.setBounds(378, 349, 217, 32);
		panel.add(textField_addr);

		JButton submitBtn = new JButton("Submit");
		submitBtn.setBounds(332, 409, 156, 23);
		panel.add(submitBtn);
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						submitBtnActionPerformed(e);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "--None--", "1 - Inventory Manager", "2 - Supplier", "3 - HR" }));
		comboBox.setBounds(378, 92, 217, 22);
		panel.add(comboBox);

		textField_dob = new JTextField();
		textField_dob.setColumns(10);
		textField_dob.setBounds(378, 306, 217, 32);
		panel.add(textField_dob);

		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				try {
					new HumanResourcesHomePage(frame);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		backBtn.setBounds(28, 11, 89, 23);
		panel.add(backBtn);

		JLabel addUserLabel = new JLabel("Add Users");
		addUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addUserLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		addUserLabel.setBounds(332, 15, 156, 14);
		panel.add(addUserLabel);

		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new LogoutPage(frame);
			}
		});
		btnNewButton.setBounds(593, 10, 89, 23);
		panel.add(btnNewButton);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(239, 263, 98, 32);
		panel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(378, 263, 217, 32);
		panel.add(passwordField);
		frame.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	public void submitBtnActionPerformed(ActionEvent e) throws ParseException, ClassNotFoundException, IOException {
		System.out.println("Submit button is clicked after adding a new user");

		System.out.println("ID is " + textField_ID.getText());
		System.out.println("first name is " + textField_firstName.getText());
		System.out.println("last name is " + textField_lastname.getText());
		System.out.println("email is " + textField_email.getText());
		System.out.println("addr is " + textField_addr.getText());
		System.out.println("dob is " + textField_dob.getText());
		System.out.println("Role is " + comboBox.getSelectedItem().toString());

		// create new person
		String role = comboBox.getSelectedItem().toString();
		int roleId = Integer.parseInt(role.substring(0, 1));
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(textField_dob.getText());
		if(roleId == 1) {
			InventoryManager im = new InventoryManager(Integer.parseInt(textField_ID.getText()), Integer.parseInt(role.substring(0, 1)),
					textField_firstName.getText(), textField_lastname.getText(), 
					textField_email.getText(), dob, textField_addr.getText(), new Account());
			im.getAccount().setUserName(textField_email.getText());
			im.getAccount().setPassword(new String(passwordField.getPassword()));
		//	List<InventoryManager> m = new ArrayList<>();
		//	MainFrame.getCompany().setManagers(m);
			im.setOrders(new ArrayList<>());
			MainFrame.getCompany().getManagers().add(im);
			FileWriterReader f = new FileWriterReader();
			f.saveAll();
		}
		else if(roleId == 2) {
			Supplier supplier = new Supplier(Integer.parseInt(textField_ID.getText()), Integer.parseInt(role.substring(0, 1)),
					textField_firstName.getText(), textField_lastname.getText(), 
					textField_email.getText(), dob, textField_addr.getText(), new Account());
			supplier.getAccount().setUserName(textField_email.getText());
			supplier.getAccount().setPassword(new String(passwordField.getPassword()));
			supplier.setOrders(new ArrayList<>());
			MainFrame.getCompany().getSuppliers().add(supplier);
			FileWriterReader f = new FileWriterReader();
			f.saveAll();
		}
		else if(roleId == 3){
			HR hr = new HR(Integer.parseInt(textField_ID.getText()), Integer.parseInt(role.substring(0, 1)),
					textField_firstName.getText(), textField_lastname.getText(), 
					textField_email.getText(), dob, textField_addr.getText(), new Account());
			
			hr.getAccount().setUserName(textField_email.getText());
			hr.getAccount().setPassword(new String(passwordField.getPassword()));
			MainFrame.getCompany().getHrs().add(hr);
			FileWriterReader f = new FileWriterReader();
			f.saveAll();
		}
		
		FileWriterReader fileUtil = new FileWriterReader(MainFrame.getCompany());
		fileUtil.saveAll();
		
		frame.getContentPane().removeAll();
		new HumanResourcesHomePage(frame);

	}

}
