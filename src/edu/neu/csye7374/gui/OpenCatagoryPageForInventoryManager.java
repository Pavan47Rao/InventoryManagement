package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class OpenCatagoryPageForInventoryManager {
	
	private JFrame frame;
	private JPanel panel;
	private JDesktopPane desktopPane;
	private JComboBox categoryComboBox, statusComboBox;
	private JButton addBtn, editBtn, deleteBtn;
	private JButton backBtn;
	private JTable table;
	
	public OpenCatagoryPageForInventoryManager(JFrame frame) {
		this.frame = frame;
	prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().revalidate();
		frame.getContentPane().add(panel);
		
		JLabel headerLabel = new JLabel("Inventory Management - Category");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		headerLabel.setBounds(242, 11, 288, 14);
		panel.add(headerLabel);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 92, 372, 183);
		panel.add(desktopPane);
		
		JLabel categoryLabel1 = new JLabel("Category:");
		categoryLabel1.setBounds(10, 26, 49, 14);
		desktopPane.add(categoryLabel1);
		
		 categoryComboBox = new JComboBox();
		categoryComboBox.setBounds(82, 22, 189, 22);
		desktopPane.add(categoryComboBox);
		
		JLabel statusLabel = new JLabel("Status:");
		statusLabel.setBounds(10, 69, 49, 14);
		desktopPane.add(statusLabel);
		
		statusComboBox = new JComboBox();
		statusComboBox.setBounds(82, 65, 189, 22);
		desktopPane.add(statusComboBox);
		
		addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCategoryActionPerformed(e);
			}
		});
		addBtn.setBounds(0, 119, 101, 23);
		desktopPane.add(addBtn);
		
		editBtn = new JButton("Edit");
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editCategoryActionPerformed(e);
			}
		});
		editBtn.setBounds(111, 119, 120, 23);
		desktopPane.add(editBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCategoryActionPerformed(e);
			}
		});
		deleteBtn.setBounds(241, 119, 107, 23);
		desktopPane.add(deleteBtn);
		
		DefaultTableModel modelTable = loadTable();
		
		JLabel ctegoryLabel = new JLabel("Category");
		ctegoryLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ctegoryLabel.setBounds(10, 69, 91, 14);
		panel.add(ctegoryLabel);
		
		backBtn = new JButton("<- Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackToInventoryManagerHomePage(e);
			}
		});
		backBtn.setBounds(687, 8, 89, 23);
		panel.add(backBtn);
		
		table = new JTable(modelTable);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(410, 69, 366, 298);
		
		panel.add(scrollPane);
		
		
		
		
		
		frame.setVisible(true);
	}
	
	private void addCategoryActionPerformed(ActionEvent evt) {
		System.out.println("Add category button is clicked");
	}
	
	private void editCategoryActionPerformed(ActionEvent evt) {
		System.out.println("Edit category button is clicked");
	}
	
	private void deleteCategoryActionPerformed(ActionEvent evt) {
		System.out.println("Delete category button is clicked");
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"ID", "Category", "Status"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {"1", "TV", "Active"});
	      values.add(new String[] {"2", "Phone", "Active"});
	      values.add(new String[] {"3", "Grocery", "Active"});
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
		
	}
	
	private void goBackToInventoryManagerHomePage(ActionEvent e) {
		new InventoryManagerHomePage(frame);
	}
}
