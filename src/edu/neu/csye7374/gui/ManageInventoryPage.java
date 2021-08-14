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

public class ManageInventoryPage {
	
	private JFrame frame;
	private JPanel panel;
	
	
	public ManageInventoryPage(JFrame frame) {
		System.out.print("Inside the constructor of open brand for inventory manager");
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
	panel = new JPanel();
	panel.setBounds(new Rectangle(800, 500));
	panel.setLayout(null);
	frame.getContentPane().add(panel);
	
	JLabel headerLabel = new JLabel("Inventory");
	headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
	headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
	headerLabel.setBounds(303, 11, 263, 14);
	panel.add(headerLabel);
	
	JButton addInventoryBtn = new JButton("Add Inventory");
	addInventoryBtn.setBounds(10, 75, 143, 60);
	panel.add(addInventoryBtn);
	
	JButton editInventoryBtn = new JButton("Edit Inventory");
	editInventoryBtn.setBounds(10, 171, 143, 60);
	panel.add(editInventoryBtn);
	
	JButton btnDeleteInventory = new JButton("Delete Inventory");
	btnDeleteInventory.setBounds(10, 273, 143, 60);
	panel.add(btnDeleteInventory);
	
	JButton backBtn = new JButton("Back");
	backBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	backBtn.setBounds(10, 8, 89, 23);
	panel.add(backBtn);
	
	JButton logoutBtn = new JButton("Logout");
	logoutBtn.setBounds(702, 8, 89, 23);
	panel.add(logoutBtn);
	
	DefaultTableModel model = loadTable();
	
	JTable table = new JTable(model);
	
	
	
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setBounds(188, 67, 527, 398);
	panel.add(scrollPane);
	
	frame.setVisible(true);
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Inventory ID", "Inventory Name", "Inventory Description"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {"IN1", "Inventory One", "Inventory for electronics"});
	     
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
		
	}

}
