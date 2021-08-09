package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {
	
	private JFrame frmInventoryManagement;
	private JPanel panel;
	private JTextField userNameTextField;
	private JTextField passwordTextField;
	
	public MainFrame() {
		frmInventoryManagement = new JFrame();
		prepareGUI();
		
	}
	
	private void prepareGUI() {
		frmInventoryManagement.setTitle("Inventory Management");
		frmInventoryManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventoryManagement.setBounds(10, 20, 800, 400);
		panel = new JPanel();
		
		frmInventoryManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel headerLabel = new JLabel("Inventory Management");
		headerLabel.setFont(new Font("Snap ITC", Font.BOLD, 17));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setBounds(101, 11, 504, 52);
		panel.add(headerLabel);
		
		JLabel userNameLabel = new JLabel("User Name");
		userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameLabel.setBounds(172, 95, 156, 42);
		panel.add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(338, 94, 213, 45);
		panel.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(172, 162, 156, 42);
		panel.add(passwordLabel);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(338, 161, 213, 45);
		panel.add(passwordTextField);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loginBtn.setBounds(273, 228, 137, 42);
		panel.add(loginBtn);
		
		
		frmInventoryManagement.setVisible(true);
	}
	
	private void loginActionPerformed(ActionEvent e) {
		System.out.println("Login button is clicked");
		System.out.println("Home page accordingly should open");
		
	}
	
	public static void demo() {
		new MainFrame();
	}
}
