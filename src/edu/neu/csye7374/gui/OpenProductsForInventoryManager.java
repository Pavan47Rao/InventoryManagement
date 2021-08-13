package edu.neu.csye7374.gui;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OpenProductsForInventoryManager {
	
	private JFrame frame;
	private JPanel panel;
	
	
	public OpenProductsForInventoryManager(JFrame frame) {
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 800, 400));
		frame.getContentPane().revalidate();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel productHeaderLabel = new JLabel("Inventory Management - Products");
		productHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productHeaderLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		productHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		productHeaderLabel.setBounds(161, 11, 493, 14);
		panel.add(productHeaderLabel);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(27, 53, 749, 197);
		panel.add(desktopPane);
		
		JLabel productLabel = new JLabel("Product");
		productLabel.setBounds(10, 21, 99, 27);
		desktopPane.add(productLabel);
		
		JLabel categroyLabel = new JLabel("Category");
		categroyLabel.setBounds(10, 113, 99, 27);
		desktopPane.add(categroyLabel);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(10, 52, 99, 27);
		desktopPane.add(descriptionLabel);
		
		JLabel brandLabel = new JLabel("Brand");
		brandLabel.setBounds(10, 170, 99, 27);
		desktopPane.add(brandLabel);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setBounds(407, 21, 99, 27);
		desktopPane.add(priceLabel);
		
		JLabel qtyLabel = new JLabel("Quantity");
		qtyLabel.setBounds(407, 76, 99, 27);
		desktopPane.add(qtyLabel);
		
		JLabel barcodeLabel = new JLabel("Barcode");
		barcodeLabel.setBounds(407, 124, 99, 27);
		desktopPane.add(barcodeLabel);
		
		JLabel statusLabel = new JLabel("Status");
		statusLabel.setBounds(407, 170, 99, 27);
		desktopPane.add(statusLabel);
		
		DefaultTableModel model = loadTable();
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(27, 269, 749, 120);
		panel.add(scrollPane);
		
		
		frame.setVisible(true);
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"ID", "Product", "Description", "Category","Brand", "Price", "Quantity", "Barcode", "Status"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {"1","LG5675","LG tv with good eye picture","TV", "LG","50000","1","111","Active"});
	
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
		
	}

}
