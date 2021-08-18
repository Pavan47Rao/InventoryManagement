package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye7374.gui.LogoutPage;
import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.gui.ResetPasswordPage;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Stock;
import edu.neu.csye7374.stock.StockRepository;

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
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new LogoutPage(frame);
			}
		});
		logoutBtn.setBounds(672, 8, 89, 23);
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
				try {
					manageOrderActionPerformed(e);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		JButton resetPwdButton = new JButton("Reset Password");
		resetPwdButton.setBounds(542, 5, 130, 29);
		resetPwdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new ResetPasswordPage(frame);
			}
		});
		panel.add(resetPwdButton);
		frame.setVisible(true);
		
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Inventory ID", "Inventory Name", "Stock ID", "Stock Type",
				"Stock Description", "Item ID", "Item Name", "Item Price",
				"Item Quantity", "Item Description"};
		
	      List<String[]> values = new ArrayList<String[]>();
	      
	      String inventoryId = String.valueOf(MainFrame.getCompany().getInventory().getInventoryId());
	      String inventoryName = MainFrame.getCompany().getInventory().getInventoryName();
	     
	      Set<String> streMapSet = StockRepository.stockMap.keySet();
	      
	      for(String s: streMapSet) {
	    	  Stock stock = StockRepository.getStock(s);
	    	  stock.getStockItems().forEach(item -> {
	    		  values.add(new String[] {inventoryId, inventoryName, String.valueOf(stock.getStockId()), 
	    				  stock.getStockType(), stock.getStockDescription(), String.valueOf(item.getItemId()),
	    				  item.getItemName(), String.valueOf(item.getItemPrice()), String.valueOf(item.getItemQuantity()),
	    				  item.getItemDescription()});
	    	  });
	      }
	      
	     
	
	      
	        
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
		new ManageItemPage(frame);
	}
	
	private void manageOrderActionPerformed(ActionEvent e) throws ClassNotFoundException, IOException {
		frame.getContentPane().removeAll();
		new ManageOrderPage(frame);
	}
	
	private void manageInboundDeliveryActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new ManageInboundDeliveryPage(frame);
	}
}
