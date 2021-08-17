package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye7374.gui.LogoutPage;
import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Stock;
import edu.neu.csye7374.stock.StockRepository;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new LogoutPage(frame);
			}
		});
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
		deleteItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItemActionPerformed(e);
			}
		});
		deleteItemBtn.setBounds(10, 274, 120, 55);
		panel.add(deleteItemBtn);
		frame.setVisible(true);
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Item ID", "Item Name", "Item Price", "Item Description", "Item Quantity", "Stock"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	     for(Item item: MainFrame.getInventoryManager().getItems()) {
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
		if(table.getModel().getRowCount() <=0) {
			JOptionPane.showMessageDialog(panel, "There are no entries in the table");
		}
		
		else {
			if(checkItemSelectedInTable()) {
				JOptionPane.showMessageDialog(panel, "Please select an entry to update from table");
			} else {
				int itemId = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0)) ;
				Item editItem = new Item();
				for(Item item: MainFrame.getInventoryManager().getItems()) {
					if(item.getItemId() == itemId) {
						editItem = item;
					}
				}
				frame.getContentPane().removeAll();
				new EditItemPage(frame, editItem);
			}
		}	
		
	}
	
	private boolean checkItemSelectedInTable() {
		if(table.getSelectedRow() == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Delete Item
	 */
	
	private void deleteItemActionPerformed(ActionEvent e) {
		if(table.getModel().getRowCount() <= 0) {
			JOptionPane.showMessageDialog(panel, "There are no entries in the table");
		}
		else {
			if(checkItemSelectedInTable()) {
				JOptionPane.showMessageDialog(panel, "Please select an entry to delete from table");
			} else {
				int itemId = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0));
				Stock selectedStock = StockRepository.getStock((String)table.getValueAt(table.getSelectedRow(), 5));
				for(ListIterator<Item> itr = StockRepository.getStock(selectedStock.getStockType()).getStockItems().listIterator();itr.hasNext();) {
					Item i = itr.next();
					if(i.getItemId() == itemId){
						itr.remove();
					}
				}
				MainFrame.getInventoryManager().deleteItems(itemId);
				
				JOptionPane.showMessageDialog(panel, "Item has been deleted successfully");
			}
		}
		table.setModel(loadTable());
	}

}
