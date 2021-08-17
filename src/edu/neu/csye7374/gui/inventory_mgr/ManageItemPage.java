package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.stock.StockRepository;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ManageItemPage {
	
	private JFrame frame;
	private JPanel panel;
	private List<Item> itemList;
	private JTable table;
	
	public ManageItemPage(JFrame frame) {
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		
		
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Items");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(321, 14, 112, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new InventoryManagerHomePage(frame);
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		panel.add(btnNewButton);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(614, 8, 89, 23);
		panel.add(logoutBtn);
		
		DefaultTableModel model = loadTable();
		table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(174, 66, 529, 395);
		panel.add(scrollPane);
		
		JButton addItemBtn = new JButton("Add Items");
		addItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemActionPerformed(e);
			}
		});
		addItemBtn.setBounds(10, 77, 120, 55);
		panel.add(addItemBtn);
		
		JButton editItemBtn = new JButton("Edit Items");
		editItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editItemActionPerformed(e);
			}
		});
		editItemBtn.setBounds(10, 174, 120, 55);
		panel.add(editItemBtn);
		
		JButton deleteItemBtn = new JButton("Delete Items");
		deleteItemBtn.setBounds(10, 274, 120, 55);
		panel.add(deleteItemBtn);
		frame.setVisible(true);
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Item ID", "Item Name", "Item Price", "Item Description", "Item Quantity", "Stock"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	     for(Item item: MainFrame.getInventoryManager().getProducts()) {
	    	 values.add(new String[] {String.valueOf(item.getItemId()), item.getItemName(), String.valueOf(item.getItemPrice())
	    	, item.getItemDescription(), String.valueOf(item.getItemQuantity()), item.getStock().getStockType()	 
	    	 });
	     }
	      
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
		
	}
	
	private void addItemActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new AddItemsPage(frame);
	}
	
	private void editItemActionPerformed(ActionEvent e) {
		int itemId = (int) table.getValueAt(table.getSelectedRow(), 0);
		Item editItem = new Item();
		for(Item item: MainFrame.getInventoryManager().getProducts()) {
			if(item.getItemId() == itemId) {
				editItem = item;
			}
		}
		frame.getContentPane().removeAll();
		new EditItemPage(frame);
	}
	
	private boolean checkItemSelectedInTable() {
		if(table.getSelectedRow() == -1) {
			return false;
		} else {
			return true;
		}
	}

}
