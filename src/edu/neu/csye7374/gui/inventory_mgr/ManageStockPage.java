package edu.neu.csye7374.gui.inventory_mgr;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;

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

public class ManageStockPage {
	
	private JFrame frame;
	private JPanel panel;
	private JButton backBtn;
	private JTable table;
	private JButton addStockBtn;
	private JButton btnEditStocks;
	private JButton btnDeleteStocks;
	private JButton btnNewButton;
	
	public ManageStockPage(JFrame frame) {
		this.frame = frame;
	prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(new Rectangle(800, 500));
		frame.getContentPane().revalidate();
		frame.getContentPane().add(panel);
		
		JLabel headerLabel = new JLabel("Stocks");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		headerLabel.setBounds(242, 11, 288, 14);
		panel.add(headerLabel);
		
		DefaultTableModel modelTable = loadTable();
		
		backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackToInventoryManagerHomePage(e);
			}
		});
		backBtn.setBounds(10, 8, 89, 23);
		panel.add(backBtn);
		
		table = new JTable(modelTable);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(181, 69, 547, 381);
		
		panel.add(scrollPane);
		
		addStockBtn = new JButton("Add Stocks");
		addStockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStocksActionPerformed(e);
			}
		});
		addStockBtn.setBounds(10, 80, 141, 56);
		panel.add(addStockBtn);
		
		btnEditStocks = new JButton("Edit Stocks");
		btnEditStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStocksActionPerformed(e);
			}
		});
		btnEditStocks.setBounds(10, 183, 141, 56);
		panel.add(btnEditStocks);
		
		btnDeleteStocks = new JButton("Delete Stocks");
		btnDeleteStocks.setBounds(10, 281, 141, 56);
		panel.add(btnDeleteStocks);
		
		btnNewButton = new JButton("Logout");
		btnNewButton.setBounds(634, 8, 89, 23);
		panel.add(btnNewButton);
		
		
		
		
		
		frame.setVisible(true);
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Stock ID", "Stock Type", "Stock Description"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {"ST1", "Electronics", "Stocking electronic items"});
	      
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
		
	}
	
	private void goBackToInventoryManagerHomePage(ActionEvent e) {
		frame.getContentPane().removeAll();
		new InventoryManagerHomePage(frame);
	}
	
	private void addStocksActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new AddStocksPage(frame);
	}
	
	private void editStocksActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		new EditStockPage(frame);
	}
}
