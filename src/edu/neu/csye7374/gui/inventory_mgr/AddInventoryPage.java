package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import edu.neu.csye7374.gui.LogoutPage;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddInventoryPage {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField inventryIDTextField;
	private JTextField textField_1;
	
	public AddInventoryPage(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		
		frame.getContentPane().add(panel);
		
		JLabel addInvLabel = new JLabel("Add Inventory");
		addInvLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addInvLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		addInvLabel.setBounds(257, 14, 208, 20);
		panel.add(addInvLabel);
		
		JButton backBrn = new JButton("Back");
		backBrn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new ManageInventoryPage(frame);
			}
		});
		backBrn.setBounds(21, 11, 89, 23);
		panel.add(backBrn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new LogoutPage(frame);
			}
		});
		logoutBtn.setBounds(597, 11, 89, 23);
		panel.add(logoutBtn);
		
		JLabel inventryIDLabel = new JLabel("Inventory ID");
		inventryIDLabel.setBounds(216, 63, 139, 36);
		panel.add(inventryIDLabel);
		
		inventryIDTextField = new JTextField();
		inventryIDTextField.setBounds(369, 63, 229, 36);
		panel.add(inventryIDTextField);
		inventryIDTextField.setColumns(10);
		
		JLabel inventryNameLabel = new JLabel("Inventory Label");
		inventryNameLabel.setBounds(216, 110, 139, 36);
		panel.add(inventryNameLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(369, 110, 229, 36);
		panel.add(textField_1);
		
		JLabel inventryDescLabel = new JLabel("Inventory Description");
		inventryDescLabel.setBounds(216, 168, 139, 36);
		panel.add(inventryDescLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(369, 168, 229, 160);
		panel.add(textPane);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBounds(329, 363, 89, 23);
		panel.add(submitBtn);
		frame.setVisible(true);
	}
}
