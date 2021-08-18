package edu.neu.csye7374.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HumanResourceEditUserPage {
	private JFrame frame;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_1;
	
	public HumanResourceEditUserPage(JFrame frame) {
		this.frame = frame;
		prepareGUI();
		
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(0,0,800,500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(239, 44, 98, 32);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(378, 44, 217, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(239, 87, 98, 32);
		panel.add(lblRole);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(239, 130, 98, 32);
		panel.add(lblFirstName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(378, 130, 217, 32);
		panel.add(textField_2);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(239, 177, 98, 32);
		panel.add(lblLastName);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(378, 177, 217, 32);
		panel.add(textField_3);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setBounds(239, 220, 98, 32);
		panel.add(lblEmailId);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(378, 220, 217, 32);
		panel.add(textField_4);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(239, 263, 98, 32);
		panel.add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(239, 306, 98, 32);
		panel.add(lblAddress);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(378, 306, 217, 32);
		panel.add(textField_6);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBounds(332, 366, 156, 23);
		panel.add(submitBtn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--None--", "Inventory Manager", "Supplied"}));
		comboBox.setBounds(378, 92, 217, 22);
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(378, 263, 217, 32);
		panel.add(textField_1);
		
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
		
		JLabel addUserLabel = new JLabel("Edit Users");
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
		frame.setVisible(true);
	}
}

