package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryManagerHomePage {
	
	private JFrame frame;
	private JPanel panel;
	private JTable table;
	private JButton categoryBtn, brandBtn, productBtn;
	
	public InventoryManagerHomePage(JFrame frame) {
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		categoryBtn = new JButton("Category");
		categoryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCategoryForInventoryManager(e);
			}
		});
		categoryBtn.setBounds(10, 93, 89, 23);
		panel.add(categoryBtn);
		
		brandBtn = new JButton("Brands");
		brandBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openBrandPageForInventoryManager(e);
			}
		});
		brandBtn.setBounds(10, 143, 89, 23);
		panel.add(brandBtn);
		
		productBtn = new JButton("Products");
		productBtn.setBounds(10, 188, 89, 23);
		panel.add(productBtn);
		
		table = new JTable();
		table.setBounds(109, 97, 331, 114);
		panel.add(table);
		
		JLabel welcomeLabel = new JLabel("Welcome: ");
		welcomeLabel.setBounds(24, 23, 206, 14);
		panel.add(welcomeLabel);
		
		JLabel role = new JLabel("Role:");
		role.setBounds(24, 48, 206, 14);
		panel.add(role);
		
		frame.setVisible(true);
		
	}
	
	private void openCategoryForInventoryManager(ActionEvent evt) {
		new OpenCatagoryPageForInventoryManager(frame);
	}
	
	private void openBrandPageForInventoryManager(ActionEvent e) {
		new OpenBrandPageForInventoryManager(frame);
	}
}
