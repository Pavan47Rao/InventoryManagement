package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.singleton.AirpodsFactorySingleton;
import edu.neu.csye7374.singleton.CheeseFactorySingleton;
import edu.neu.csye7374.singleton.IphoneFactorySingleton;
import edu.neu.csye7374.singleton.MilkFactorySingleton;
import edu.neu.csye7374.singleton.PenFactorySingleton;
import edu.neu.csye7374.singleton.PencilFactorySingleton;
import edu.neu.csye7374.singleton.VRHeadsetFactorySingleton;
import edu.neu.csye7374.singleton.WritingPadFactorySingleton;
import edu.neu.csye7374.singleton.YogurtFactorySingleton;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddItemsPage {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField idField;
	private JTextField nameField;
	private JTextField priceField;
	private JTextField qtyField;
	private List<AbstractItemFactory> itemList;
	
	public AddItemsPage(JFrame frame) {
	this.frame = frame;
	itemList = new ArrayList<AbstractItemFactory>();
	populateItemList(itemList);
	prepareGUI();
	
	}
	
	private void populateItemList(List<AbstractItemFactory> itemList) {
		System.out.print("Populate item list method");
		AbstractItemFactory airpodsFactory, cheeseFactory, iphoneFactory,
		milkFactory, pencilFactory, penFactory, vrheadsetFactory, writingpadFactory, yogurFactory;
		
		airpodsFactory = AirpodsFactorySingleton.getObject();
		cheeseFactory = CheeseFactorySingleton.getObject();
		iphoneFactory = IphoneFactorySingleton.getObject();
		milkFactory = MilkFactorySingleton.getObject();
		pencilFactory = PencilFactorySingleton.getObject();
		penFactory = PenFactorySingleton.getObject();
		vrheadsetFactory = VRHeadsetFactorySingleton.getObject();
		writingpadFactory = WritingPadFactorySingleton.getObject();
		yogurFactory = YogurtFactorySingleton.getObject();
		
		itemList.add(airpodsFactory);
		itemList.add(cheeseFactory);
		itemList.add(yogurFactory);
		itemList.add(iphoneFactory);
		itemList.add(pencilFactory);
		itemList.add(penFactory);
		itemList.add(milkFactory);
		itemList.add(vrheadsetFactory);
		itemList.add(writingpadFactory);
		
		
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JLabel addItemHeaderLabel = new JLabel("Add Items");
		addItemHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addItemHeaderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		addItemHeaderLabel.setBounds(256, 11, 207, 23);
		panel.add(addItemHeaderLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new ManageItemPage(frame);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		panel.add(btnBack);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(586, 7, 89, 23);
		panel.add(logoutBtn);
		
		JLabel lblNewLabel = new JLabel("Item ID");
		lblNewLabel.setBounds(225, 55, 108, 34);
		panel.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setBounds(342, 53, 220, 39);
		panel.add(idField);
		idField.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(225, 102, 108, 34);
		panel.add(lblItemName);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(342, 100, 220, 39);
		panel.add(nameField);
		
		JLabel lblItemPrice = new JLabel("Item Price");
		lblItemPrice.setBounds(225, 149, 108, 34);
		panel.add(lblItemPrice);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(342, 147, 220, 39);
		panel.add(priceField);
		
		JLabel lblItemDescription = new JLabel("Item Description");
		lblItemDescription.setBounds(225, 299, 108, 34);
		panel.add(lblItemDescription);
		
		JLabel lblItemQuantity = new JLabel("Item Quantity");
		lblItemQuantity.setBounds(225, 196, 108, 34);
		panel.add(lblItemQuantity);
		
		qtyField = new JTextField();
		qtyField.setColumns(10);
		qtyField.setBounds(342, 194, 220, 39);
		panel.add(qtyField);
		
		JLabel stockLabel = new JLabel("Stock");
		stockLabel.setBounds(225, 243, 108, 34);
		panel.add(stockLabel);
		
		/*
		 * Code to populate comboBox
		 */
		JComboBox stockCombo = new JComboBox(itemList.toArray());
		stockCombo.setBounds(342, 249, 220, 34);
		panel.add(stockCombo);
		
		JTextArea descPane = new JTextArea();
		descPane.setBounds(342, 304, 220, 93);
		panel.add(descPane);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(306, 419, 89, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}

}
