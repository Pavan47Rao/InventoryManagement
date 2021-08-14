package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EditStockPage {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField stockIdTextField;
	
	public EditStockPage(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JLabel addStockHeaderLable = new JLabel("Edit Stocks");
		addStockHeaderLable.setHorizontalAlignment(SwingConstants.CENTER);
		addStockHeaderLable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		addStockHeaderLable.setBounds(241, 11, 221, 14);
		panel.add(addStockHeaderLable);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new ManageStockPage(frame);
			}
		});
		backBtn.setBounds(37, 8, 89, 23);
		panel.add(backBtn);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(529, 8, 89, 23);
		panel.add(logoutBtn);
		
		JLabel stockIdLabel = new JLabel("Stock ID");
		stockIdLabel.setBounds(186, 59, 127, 36);
		panel.add(stockIdLabel);
		
		stockIdTextField = new JTextField();
		stockIdTextField.setBounds(323, 59, 221, 36);
		panel.add(stockIdTextField);
		stockIdTextField.setColumns(10);
		
		JLabel lblStockType = new JLabel("Stock Type");
		lblStockType.setBounds(186, 113, 127, 36);
		panel.add(lblStockType);
		
		JLabel lblStockDescription = new JLabel("Stock Description");
		lblStockDescription.setBounds(186, 171, 127, 36);
		panel.add(lblStockDescription);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(323, 113, 221, 36);
		panel.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(323, 177, 221, 97);
		panel.add(textArea);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBounds(273, 296, 136, 36);
		panel.add(submitBtn);
		frame.setVisible(true);
		
	}
}



