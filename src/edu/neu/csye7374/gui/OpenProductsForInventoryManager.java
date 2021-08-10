package edu.neu.csye7374.gui;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OpenProductsForInventoryManager {
	
	private JFrame frame;
	private JPanel panel;
	
	
	public OpenProductsForInventoryManager(JFrame frame) {
		this.frame = frame;
		panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 800, 400));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		frame.setVisible(true);
	}

}
