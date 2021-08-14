package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditItemPage {
	private JFrame frame;
	private JPanel panel;
	private JTextField idField;
	private JTextField nameField;
	private JTextField priceField;
	private JTextField qtyField;
	
	public EditItemPage(JFrame frame) {
	this.frame = frame;
	prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JLabel addItemHeaderLabel = new JLabel("Edit Items");
		addItemHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addItemHeaderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		addItemHeaderLabel.setBounds(256, 11, 207, 23);
		panel.add(addItemHeaderLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new ManageItemPage(frame);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		panel.add(btnBack);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(586, 7, 89, 23);
		panel.add(logoutBtn);
		
		JLabel lblNewLabel = new JLabel("Item ID");
		lblNewLabel.setBounds(225, 55, 108, 34);
		panel.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setBounds(342, 53, 220, 39);
		panel.add(idField);
		idField.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(225, 102, 108, 34);
		panel.add(lblItemName);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(342, 100, 220, 39);
		panel.add(nameField);
		
		JLabel lblItemPrice = new JLabel("Item Price");
		lblItemPrice.setBounds(225, 149, 108, 34);
		panel.add(lblItemPrice);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(342, 147, 220, 39);
		panel.add(priceField);
		
		JLabel lblItemDescription = new JLabel("Item Description");
		lblItemDescription.setBounds(225, 299, 108, 34);
		panel.add(lblItemDescription);
		
		JLabel lblItemQuantity = new JLabel("Item Quantity");
		lblItemQuantity.setBounds(225, 196, 108, 34);
		panel.add(lblItemQuantity);
		
		qtyField = new JTextField();
		qtyField.setColumns(10);
		qtyField.setBounds(342, 194, 220, 39);
		panel.add(qtyField);
		
		JLabel stockLabel = new JLabel("Stock");
		stockLabel.setBounds(225, 243, 108, 34);
		panel.add(stockLabel);
		
		JComboBox stockCombo = new JComboBox();
		stockCombo.setBounds(342, 249, 220, 34);
		panel.add(stockCombo);
		
		JTextArea descPane = new JTextArea();
		descPane.setBounds(342, 304, 220, 93);
		panel.add(descPane);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(306, 419, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}

}
