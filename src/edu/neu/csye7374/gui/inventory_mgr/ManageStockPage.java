package edu.neu.csye7374.gui.inventory_mgr;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.model.Stock;
import edu.neu.csye7374.stock.StockRepository;

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
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ManageStockPage {
	
	private JFrame frame;
	private JPanel panel;
	private JButton backBtn;
	private JTable table;
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
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(181, 69, 547, 381);
		
		panel.add(scrollPane);
		
		btnEditStocks = new JButton("View Stock Details");
		btnEditStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewStocksActionPerformed(e);
			}
		});
		btnEditStocks.setBounds(10, 130, 141, 56);
		panel.add(btnEditStocks);
		
		btnDeleteStocks = new JButton("Delete Stocks");
		btnDeleteStocks.setBounds(10, 253, 141, 56);
		panel.add(btnDeleteStocks);
		
		btnNewButton = new JButton("Logout");
		btnNewButton.setBounds(634, 8, 89, 23);
		panel.add(btnNewButton);
		
		
		
		
		
		frame.setVisible(true);
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Stock ID", "Stock Type", "Stock Description"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      Set<String> stockMapSet = StockRepository.stockMap.keySet();
	      for(String s: stockMapSet) {
	    	  Stock stock = StockRepository.getStock(s);
	    	  values.add(new String[] {String.valueOf(stock.getStockId()), stock.getStockType(), stock.getStockDescription()});
	      }
	      
	     
	      
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
		
	}
	
	private void goBackToInventoryManagerHomePage(ActionEvent e) {
		frame.getContentPane().removeAll();
		new InventoryManagerHomePage(frame);
	}
	
	private void viewStocksActionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		if(StockRepository.stockMap.size() <= 0) {
			JOptionPane.showMessageDialog(panel, "There are no stocks currently present");
			
		}
		else {
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(panel, "Please select a stock to view details");
			} else {
				String stockType = (String)table.getValueAt(table.getSelectedRow(), 1);
				Stock viewStock = StockRepository.getStock(stockType);
				new EditStockPage(frame, viewStock);
				
			}
		}
		
		
	}
}
