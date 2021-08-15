package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ManageInboundDeliveryPage {
	
	private JFrame frame;
	private JPanel panel;
	
	public ManageInboundDeliveryPage(JFrame frame) {
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JLabel inboundDeliveryLabel = new JLabel("Inbound Delivery");
		inboundDeliveryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inboundDeliveryLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		inboundDeliveryLabel.setBounds(232, 11, 293, 18);
		panel.add(inboundDeliveryLabel);
		
		DefaultTableModel model = loadTable();
		JTable table = new JTable(model);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(90, 74, 614, 278);
		panel.add(scrollPane);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new InventoryManagerHomePage(frame);
			}
		});
		backBtn.setBounds(21, 10, 89, 23);
		panel.add(backBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(615, 10, 89, 23);
		panel.add(logoutBtn);
		
		JButton acceptDeliveryBtn = new JButton("Accept Delivery");
		acceptDeliveryBtn.setBounds(304, 363, 188, 23);
		panel.add(acceptDeliveryBtn);
		frame.setVisible(true);
		
	}
	
	private DefaultTableModel loadTable() {
		String[] columns = {"Order ID", "Amount", "Item ID", "Quantity"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	      values.add(new String[] {"O1", "10000.00", "1", "20"});
	      
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
	}

}
