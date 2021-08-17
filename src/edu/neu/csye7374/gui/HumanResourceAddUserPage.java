package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;

import edu.neu.csye7374.gui.inventory_mgr.InventoryManagerHomePage;
import edu.neu.csye7374.gui.supplier.SupplierHomePage;
import edu.neu.csye7374.model.Account;
import edu.neu.csye7374.model.Person;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

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
					submitBtnActionPerformed(e);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "--None--", "1 - Inventory Manager", "2 - HR", "3 - Supplied" }));
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
				new HumanResourcesHomePage(frame);
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
	public void submitBtnActionPerformed(ActionEvent e) throws ParseException {
		System.out.println("Submit button is clicked after adding a new user");

		System.out.println("ID field is " + textField_ID.getText());
		System.out.println("first name is " + textField_firstName.getText());
		System.out.println("last name is " + textField_lastname.getText());
		System.out.println("email field is " + textField_email.getText());
		System.out.println("addr field is " + textField_addr.getText());
		System.out.println("dob field is " + textField_dob.getText());
		System.out.println("Role field is " + comboBox.getSelectedItem().toString());

		// create new person
		Person newPerson = new Person();
		newPerson.setPersonId(Integer.parseInt(textField_ID.getText()));
		newPerson.setFirstName(textField_firstName.getText());
		newPerson.setLastName(textField_lastname.getText());
		newPerson.setEmailId(textField_email.getText());
		String role = comboBox.getSelectedItem().toString();
		newPerson.setRoleId(Integer.parseInt(role.substring(0, 1)));
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(textField_dob.getText());
		newPerson.setDob(dob);
		newPerson.setPassword(passwordField.getText());

	}

}
