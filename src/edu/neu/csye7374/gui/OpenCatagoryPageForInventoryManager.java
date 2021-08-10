package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpenCatagoryPageForInventoryManager {
	
	private JFrame frame;
	private JPanel panel;
	private JTable table;
	private JDesktopPane desktopPane;
	private JComboBox categoryComboBox, statusComboBox;
	private JButton addBtn, editBtn, deleteBtn;
	
	public OpenCatagoryPageForInventoryManager(JFrame frame) {
		this.frame = frame;
	prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JLabel headerLabel = new JLabel("Inventory Management - Category");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		headerLabel.setBounds(62, 11, 288, 14);
		panel.add(headerLabel);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 92, 372, 183);
		panel.add(desktopPane);
		
		JLabel categoryLabel1 = new JLabel("Category:");
		categoryLabel1.setBounds(10, 26, 49, 14);
		desktopPane.add(categoryLabel1);
		
		 categoryComboBox = new JComboBox();
		categoryComboBox.setBounds(82, 22, 98, 22);
		desktopPane.add(categoryComboBox);
		
		JLabel statusLabel = new JLabel("Status:");
		statusLabel.setBounds(10, 69, 49, 14);
		desktopPane.add(statusLabel);
		
		statusComboBox = new JComboBox();
		statusComboBox.setBounds(82, 65, 98, 22);
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
		
		table = new JTable();
		table.setBounds(404, 55, 372, 298);
		panel.add(table);
		
		JLabel ctegoryLabel = new JLabel("Category");
		ctegoryLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ctegoryLabel.setBounds(10, 69, 91, 14);
		panel.add(ctegoryLabel);
		
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
}
