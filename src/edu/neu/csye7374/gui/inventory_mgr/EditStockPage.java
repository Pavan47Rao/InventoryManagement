package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Stock;
import edu.neu.csye7374.stock.StockRepository;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EditStockPage {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField stockIdTextField;
	private Stock viewStock;
	private JTable table;
	private JComboBox comboBox;
	private JTextArea textArea;
	
	public EditStockPage(JFrame frame, Stock viewStock) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		this.viewStock = viewStock;
		prepareGUI();
		populateFields(viewStock);
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JLabel addStockHeaderLable = new JLabel("View Stock Details");
		addStockHeaderLable.setHorizontalAlignment(SwingConstants.CENTER);
		addStockHeaderLable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		addStockHeaderLable.setBounds(241, 11, 221, 14);
		panel.add(addStockHeaderLable);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new ManageStockPage(frame);
			}
		});
		backBtn.setBounds(37, 8, 89, 23);
		panel.add(backBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(529, 8, 89, 23);
		panel.add(logoutBtn);
		
		JLabel stockIdLabel = new JLabel("Stock ID");
		stockIdLabel.setBounds(37, 60, 127, 36);
		panel.add(stockIdLabel);
		
		stockIdTextField = new JTextField();
		stockIdTextField.setEnabled(false);
		stockIdTextField.setEditable(false);
		stockIdTextField.setBounds(174, 60, 221, 36);
		panel.add(stockIdTextField);
		stockIdTextField.setColumns(10);
		
		JLabel lblStockType = new JLabel("Stock Type");
		lblStockType.setBounds(37, 114, 127, 36);
		panel.add(lblStockType);
		
		JLabel lblStockDescription = new JLabel("Stock Description");
		lblStockDescription.setBounds(37, 172, 127, 36);
		panel.add(lblStockDescription);
		
		Set<String> stockMapSet = StockRepository.stockMap.keySet();
		
		
		 comboBox = new JComboBox(stockMapSet.toArray());
		comboBox.setEnabled(false);
		comboBox.setBounds(174, 114, 221, 36);
		panel.add(comboBox);
		
		 textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(174, 178, 221, 97);
		panel.add(textArea);
		
		DefaultTableModel model = loadTable();
		JTable table = new JTable(model);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(405, 60, 385, 413);
		panel.add(scrollPane);
		frame.setVisible(true);
		
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Item ID", "Item Name", "Item Price", "Item Description", "Item Quantity", "Stock"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	     for(Item item: viewStock.getStockItems()) {
	    	 values.add(new String[] {String.valueOf(item.getItemId()), item.getItemName(), String.valueOf(item.getItemPrice())
	    	, item.getItemDescription(), String.valueOf(item.getItemQuantity()), item.getStock().getStockType()	 
	    	 });
	     }
	      
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
		
	}
	
	private void populateFields(Stock viewStock) {
		stockIdTextField.setText(String.valueOf(viewStock.getStockId()));
		comboBox.setSelectedItem(viewStock.getStockType());
		textArea.setText(viewStock.getStockDescription());
	}
}



