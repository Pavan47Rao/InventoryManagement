package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class OpenBrandPageForInventoryManager {
	
	private JFrame frame;
	private JPanel panel;
	private JButton addBtn, editBtn, deleteBtn;
	private JComboBox statusComboBox, brandComboBox;
	private JTable table;
	
	
	public OpenBrandPageForInventoryManager(JFrame frame) {
		System.out.print("Inside the constructor of open brand for inventory manager");
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		panel.setBounds(new Rectangle(0, 0, 800, 400));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		DefaultTableModel model = loadBrandTable();
		table = new JTable(model);
		
		JScrollPane tablePane = new JScrollPane(table);
		tablePane.setBounds(420, 62, 363, 299);
		panel.add(tablePane);
		
		JLabel brandHeaderLable = new JLabel("Inventory Management - Brand");
		brandHeaderLable.setHorizontalAlignment(SwingConstants.CENTER);
		brandHeaderLable.setFont(new Font("Tahoma", Font.BOLD, 13));
		brandHeaderLable.setBounds(219, 11, 389, 14);
		panel.add(brandHeaderLable);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(26, 92, 352, 256);
		panel.add(desktopPane);
		
		JLabel brandLabel = new JLabel("Brand");
		brandLabel.setBounds(10, 56, 91, 18);
		desktopPane.add(brandLabel);
		
		brandComboBox = new JComboBox();
		brandComboBox.setBounds(111, 54, 206, 22);
		desktopPane.add(brandComboBox);
		
		JLabel statusLabel = new JLabel("Status");
		statusLabel.setBounds(10, 110, 91, 18);
		desktopPane.add(statusLabel);
		
		statusComboBox = new JComboBox();
		statusComboBox.setBounds(111, 108, 206, 22);
		desktopPane.add(statusComboBox);
		
		addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBrandActionPerformed(e);
			}
		});
		addBtn.setBounds(10, 180, 89, 23);
		desktopPane.add(addBtn);
		
		editBtn = new JButton("Edit");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editBrandActionPerformed(e);
			}
		});
		editBtn.setBounds(134, 180, 89, 23);
		desktopPane.add(editBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBrandActionPerformed(e);
			}
		});
		deleteBtn.setBounds(253, 180, 89, 23);
		desktopPane.add(deleteBtn);
		frame.setVisible(true);
	}
	
	private DefaultTableModel loadBrandTable() {
		String[] columns = {"ID", "Brand", "Status"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {"1", "LG", "Active"});
	      values.add(new String[] {"2", "Samsung", "Active"});
	      values.add(new String[] {"3", "Market Pantry", "Active"});
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
		
	}
	
	
	private void addBrandActionPerformed(ActionEvent evt) {
		System.out.println("Add brand button is clicked");
	}
	
	private void editBrandActionPerformed(ActionEvent evt) {
		System.out.println("Edit brand button is clicked");
	}
	
	private void deleteBrandActionPerformed(ActionEvent evt) {
		System.out.println("Delete brand button is clicked");
	}

}
