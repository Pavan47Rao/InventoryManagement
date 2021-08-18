package edu.neu.csye7374.gui.inventory_mgr;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye7374.gui.LogoutPage;
import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.stock.StockRepository;

import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ManageInventoryPage {
	
	private JFrame frame;
	private JPanel panel;
	
	
	public ManageInventoryPage(JFrame frame) {
		System.out.print("Inside the constructor of open brand for inventory manager");
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
	panel = new JPanel();
	panel.setBounds(new Rectangle(800, 500));
	panel.setLayout(null);
	frame.getContentPane().add(panel);
	
	JLabel headerLabel = new JLabel("Inventory");
	headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
	headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
	headerLabel.setBounds(303, 11, 263, 14);
	panel.add(headerLabel);
	
	JButton backBtn = new JButton("Back");
	backBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
			new InventoryManagerHomePage(frame);
		}
	});
	backBtn.setBounds(10, 8, 89, 23);
	panel.add(backBtn);
	
	JButton logoutBtn = new JButton("Logout");
	logoutBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
			new LogoutPage(frame);
		}
	});
	logoutBtn.setBounds(606, 8, 89, 23);
	panel.add(logoutBtn);
	
	DefaultTableModel model = loadTable();
	
	JTable table = new JTable(model);
	
	
	
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setBounds(41, 67, 703, 312);
	panel.add(scrollPane);
	
	frame.setVisible(true);
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Inventory ID", "Inventory Name", "Number of Stocks"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {String.valueOf(MainFrame.getCompany().getInventory().getInventoryId()), MainFrame.getCompany().getInventory().getInventoryName(), String.valueOf(StockRepository.stockMap.size())});
	     
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
		
	}

}
