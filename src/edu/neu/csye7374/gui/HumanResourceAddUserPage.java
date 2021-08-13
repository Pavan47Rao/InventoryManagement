package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HumanResourceAddUserPage {
	
	private JFrame frame;
	private JPanel panel;
	
	public HumanResourceAddUserPage(JFrame frame) {
		this.frame = frame;
		panel = new JPanel();
		panel.setBounds(0,0,800,400);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
	}

}
