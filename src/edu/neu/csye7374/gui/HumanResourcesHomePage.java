package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class HumanResourcesHomePage {
	
	private JFrame frame;
	private JPanel panel;
	
	public HumanResourcesHomePage(JFrame frame) {
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logoutBtn.setBounds(645, 11, 89, 23);
		panel.add(logoutBtn);
		
		DefaultTableModel model = loadTable();
		
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(158, 52, 632, 337);
		panel.add(scrollPane);
		
		JLabel headerLabel = new JLabel("Human Resources Home Page");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		headerLabel.setBounds(158, 15, 444, 14);
		panel.add(headerLabel);
		
		JButton addBtn = new JButton("Add Users");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUserActionPerformed(e);
			}
		});
		addBtn.setBounds(10, 52, 138, 63);
		panel.add(addBtn);
		
		JButton deleteUserBtn = new JButton("Delete User");
		deleteUserBtn.setBounds(10, 231, 138, 63);
		panel.add(deleteUserBtn);
		
		JButton editIUserBtn = new JButton("Edit User");
		editIUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editUserActionPerformed(e);
			}
		});
		editIUserBtn.setBounds(10, 145, 138, 63);
		panel.add(editIUserBtn);
		
		frame.setVisible(true);
	}
	
	private void addUserActionPerformed(ActionEvent e) {
	
		frame.getContentPane().removeAll();
		new HumanResourceAddUserPage(frame);
	}
	
	private void editUserActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new HumanResourceEditUserPage(frame);
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"ID", "Role", "First Name", "Last Name", "Email ID", "Date of Birth", "Address" };
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {"1", "Inventory Manager", "Siddhant", "Rao", "rao.sid@northeastern.edu", "12/07/1991", "Boston"});
	     
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
	}
	
	
}
