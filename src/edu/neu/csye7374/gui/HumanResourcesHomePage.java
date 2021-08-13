package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HumanResourcesHomePage {
	
	private JFrame frame;
	private JPanel panel;
	
	public HumanResourcesHomePage(JFrame frame) {
		this.frame = frame;
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton backBtn = new JButton("<-- Back");
		backBtn.setBounds(645, 11, 89, 23);
		panel.add(backBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 52, 632, 158);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(158, 231, 632, 158);
		panel.add(scrollPane_1);
		
		JLabel headerLabel = new JLabel("Human Resources Home Page");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		headerLabel.setBounds(158, 15, 444, 14);
		panel.add(headerLabel);
		
		JButton addBtn = new JButton("Add Users");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUserActionPerformed(e);
			}
		});
		addBtn.setBounds(10, 52, 138, 63);
		panel.add(addBtn);
		
		JButton deleteUserBtn = new JButton("Delete User");
		deleteUserBtn.setBounds(10, 231, 138, 63);
		panel.add(deleteUserBtn);
		
		JButton editIUserBtn = new JButton("Edit User");
		editIUserBtn.setBounds(10, 145, 138, 63);
		panel.add(editIUserBtn);
		
		frame.setVisible(true);
	}
	
	private void addUserActionPerformed(ActionEvent e) {
		JPanel addUserPanel = new JPanel();
		frame.getContentPane().removeAll();
		frame.getContentPane().add(addUserPanel);
		frame.setVisible(true);
	}
	
	
}
