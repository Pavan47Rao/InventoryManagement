package edu.neu.csye7374.gui;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;

public class OpenProductsForInventoryManager {
	
	private JFrame frame;
	private JPanel panel;
	
	
	public OpenProductsForInventoryManager(JFrame frame) {
		this.frame = frame;
		panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 800, 400));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel productHeaderLabel = new JLabel("Inventory Management - Products");
		productHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productHeaderLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		productHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		productHeaderLabel.setBounds(161, 11, 493, 14);
		panel.add(productHeaderLabel);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(27, 53, 749, 197);
		panel.add(desktopPane);
		
		JLabel productLabel = new JLabel("Product");
		productLabel.setBounds(10, 21, 99, 27);
		desktopPane.add(productLabel);
		
		JLabel categroyLabel = new JLabel("Category");
		categroyLabel.setBounds(10, 113, 99, 27);
		desktopPane.add(categroyLabel);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(10, 52, 99, 27);
		desktopPane.add(descriptionLabel);
		
		JLabel label_2_1 = new JLabel("New label");
		label_2_1.setBounds(10, 170, 99, 27);
		desktopPane.add(label_2_1);
		
		JLabel label_2_2 = new JLabel("New label");
		label_2_2.setBounds(407, 21, 99, 27);
		desktopPane.add(label_2_2);
		
		JLabel label_2_3 = new JLabel("New label");
		label_2_3.setBounds(407, 76, 99, 27);
		desktopPane.add(label_2_3);
		
		JLabel label_2_4 = new JLabel("New label");
		label_2_4.setBounds(407, 124, 99, 27);
		desktopPane.add(label_2_4);
		
		JLabel label_2_5 = new JLabel("New label");
		label_2_5.setBounds(407, 170, 99, 27);
		desktopPane.add(label_2_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 269, 749, 120);
		panel.add(scrollPane);
		
		
		frame.setVisible(true);
	}

}
