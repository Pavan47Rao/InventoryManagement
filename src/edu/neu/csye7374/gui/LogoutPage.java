package edu.neu.csye7374.gui;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LogoutPage {
	
	private JFrame frame;
	private JPanel panel;
	
	public LogoutPage(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800,500));
		panel.setLayout(null);
		
		
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Thank you for using Inventory Application");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(125, 47, 530, 103);
		panel.add(lblNewLabel);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				try {
					new MainFrame();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		loginBtn.setBounds(316, 173, 171, 53);
		panel.add(loginBtn);
		frame.setVisible(true);
	}
	
	
	

}
