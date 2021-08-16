package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageOrderPage {
	private JFrame frame;
	private JPanel panel;
	private JTextField orderIdtextField;
	private JTextField textField;
	
	public ManageOrderPage(JFrame frame) {
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800,500));
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JScrollBar vScroll = new JScrollBar();
		panel.add(vScroll);
		
		JLabel purchaseOrderLabel = new JLabel("Purchase Orders");
		purchaseOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseOrderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		purchaseOrderLabel.setBounds(275, 11, 243, 14);
		panel.add(purchaseOrderLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new InventoryManagerHomePage(frame);
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(632, 8, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Order Id");
		lblNewLabel.setBounds(254, 49, 116, 41);
		panel.add(lblNewLabel);
		
		orderIdtextField = new JTextField();
		orderIdtextField.setBounds(380, 47, 209, 45);
		panel.add(orderIdtextField);
		orderIdtextField.setColumns(10);
		
		JLabel itemLabel = new JLabel("Item");
		itemLabel.setBounds(254, 101, 116, 41);
		panel.add(itemLabel);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setBounds(254, 157, 116, 41);
		panel.add(lblQuantity_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(380, 153, 209, 45);
		panel.add(textField);
		
		JComboBox itemCombo = new JComboBox();
		itemCombo.setBounds(380, 101, 209, 41);
		panel.add(itemCombo);
		
		JLabel supplierLabel = new JLabel("Supplier");
		supplierLabel.setBounds(254, 211, 116, 41);
		panel.add(supplierLabel);
		
		JComboBox supplierCombo = new JComboBox();
		supplierCombo.setBounds(380, 209, 209, 45);
		panel.add(supplierCombo);
		
		JButton purchaseOrder = new JButton("Purchase Order");
		purchaseOrder.setBounds(287, 275, 275, 36);
		panel.add(purchaseOrder);
		
		JButton addItemToOrderBtn = new JButton("Add Item");
		addItemToOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemToOrderActionPerformed(e);
			}
		});
		addItemToOrderBtn.setBounds(605, 101, 127, 30);
		panel.add(addItemToOrderBtn);
		frame.setVisible(true);
	}
	
	private void addItemToOrderActionPerformed(ActionEvent e) {
		System.out.println("Adding item to order code would come here");
	}
}
