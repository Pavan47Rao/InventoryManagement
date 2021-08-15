package edu.neu.csye7374.gui.supplier;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SupplierHomePage {
	
	private JFrame frame;
	private JPanel panel;
	
	public SupplierHomePage(JFrame frame) {
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Supplier Home Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(214, 11, 295, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setBounds(629, 8, 89, 23);
		panel.add(btnNewButton);
		
		DefaultTableModel model = loadTable();
		JTable table = new JTable(model);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(103, 65, 530, 255);
		panel.add(scrollPane);
		
		JButton completeOrderBtn = new JButton("Fulfil Order");
		completeOrderBtn.setBounds(257, 346, 196, 43);
		panel.add(completeOrderBtn);
		frame.setVisible(true);
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Order ID", "Amount", "Item ID", "Quantity"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {"O1", "10000.00", "1", "20"});
	      
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
	}

}
