package edu.neu.csye7374.gui.inventory_mgr;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.model.Item;

import javax.swing.JScrollPane;

public class InventoryManagerHomePage {
	
	private JFrame frame;
	private JPanel panel;
	

	
	public InventoryManagerHomePage(JFrame frame) {
		this.frame = frame;
		prepareGUI();
		
		
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		JLabel headerLabel = new JLabel("Inventory Manager Home Page");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		headerLabel.setBounds(170, 11, 444, 14);
		panel.add(headerLabel);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(10, 8, 89, 23);
		panel.add(backBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(656, 8, 89, 23);
		panel.add(logoutBtn);
		
		DefaultTableModel model = loadTable();
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(186, 52, 556, 387);
		panel.add(scrollPane);
		
		JButton inventoryBtn = new JButton("Manage Inventory");
		inventoryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageInventoryActionPerformed(e);
			}
		});
		inventoryBtn.setBounds(10, 62, 166, 57);
		panel.add(inventoryBtn);
		
		JButton stockBtn = new JButton("Manage Stocks");
		stockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageStocksActionPerformed(e);
			}
		});
		stockBtn.setBounds(10, 142, 166, 57);
		panel.add(stockBtn);
		
		JButton itemBtn = new JButton("Manage Items");
		itemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageItemsActionPerformed(e);
			}
		});
		itemBtn.setBounds(10, 222, 166, 57);
		panel.add(itemBtn);
		
		JButton orderBtn = new JButton("Manage Orders");
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageOrderActionPerformed(e);
			}
		});
		orderBtn.setBounds(10, 304, 166, 57);
		panel.add(orderBtn);
		
		JButton inboundBtn = new JButton("Manage Inbound Delivery");
		inboundBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageInboundDeliveryActionPerformed(e);
			}
		});
		inboundBtn.setBounds(10, 382, 166, 57);
		panel.add(inboundBtn);
		frame.getContentPane().revalidate();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Inventory ID", "Inventory Name", "Inventory Description", "Stock ID", "Stock Type", "Stock Description", "Item ID", "Item Name", "Item Price", "Item Quantity", "Item Description"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {"IN1", "Inventory One", "Inventory One", "ST1", "Electronics", "Contains electronics item", "1", "Samsung TV", "10000.00", "100","TV with 4K UHD"});
	
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
	}
	
	private void manageInventoryActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new ManageInventoryPage(frame);
	}
	
	private void manageStocksActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new ManageStockPage(frame);
	}
	
	private void manageItemsActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new ManageItemPage(frame, MainFrame.getItemList());
	}
	
	private void manageOrderActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new ManageOrderPage(frame);
	}
	
	private void manageInboundDeliveryActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new ManageInboundDeliveryPage(frame);
	}
}
