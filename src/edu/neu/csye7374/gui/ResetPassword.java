package edu.neu.csye7374.gui;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ResetPassword {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField textField;
	
	ResetPassword(JFrame frame) {
		this.frame = frame;
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Reset Password");
		lblNewLabel.setBounds(229, 20, 100, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email Id");
		lblNewLabel_1.setBounds(89, 72, 100, 16);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Generate New Password");
		btnNewButton.setBounds(156, 125, 200, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create your own password");
		btnNewButton_1.setBounds(156, 179, 200, 29);
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(217, 67, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		frame.setVisible(true);
	
	}
}
