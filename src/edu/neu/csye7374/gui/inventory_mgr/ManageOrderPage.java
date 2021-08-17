package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.singleton.AirpodsFactorySingleton;
import edu.neu.csye7374.singleton.CheeseFactorySingleton;
import edu.neu.csye7374.singleton.IphoneFactorySingleton;
import edu.neu.csye7374.singleton.MilkFactorySingleton;
import edu.neu.csye7374.singleton.PenFactorySingleton;
import edu.neu.csye7374.singleton.PencilFactorySingleton;
import edu.neu.csye7374.singleton.VRHeadsetFactorySingleton;
import edu.neu.csye7374.singleton.WritingPadFactorySingleton;
import edu.neu.csye7374.singleton.YogurtFactorySingleton;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ManageOrderPage {
	private JFrame frame;
	private JPanel panel;
	private JTextField orderIdtextField;
	private JTextField textField;
	private List<AbstractItemFactory> itemFactoryList;
	private JComboBox itemCombo;
	
	public ManageOrderPage(JFrame frame) {
		this.frame = frame;
		itemFactoryList = new ArrayList<AbstractItemFactory>();
		populateItemList(itemFactoryList);
		prepareGUI();
	}
	
	private void populateItemList(List<AbstractItemFactory> itemFactoryList) {
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
		
	
		itemFactoryList.add(airpodsFactory);
		itemFactoryList.add(cheeseFactory);
		itemFactoryList.add(yogurFactory);
		itemFactoryList.add(iphoneFactory);
		itemFactoryList.add(pencilFactory);
		itemFactoryList.add(penFactory);
		itemFactoryList.add(milkFactory);
		itemFactoryList.add(vrheadsetFactory);
		itemFactoryList.add(writingpadFactory);
		
		
	}
	
	private void prepareGUI() {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800,500));
		panel.setLayout(null);
		
		frame.getContentPane().add(panel);
		
		JScrollBar vScroll = new JScrollBar();
		panel.add(vScroll);
		
		JLabel purchaseOrderLabel = new JLabel("Purchase Orders");
		purchaseOrderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseOrderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		purchaseOrderLabel.setBounds(275, 11, 243, 14);
		panel.add(purchaseOrderLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new InventoryManagerHomePage(frame);
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(632, 8, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Order Id");
		lblNewLabel.setBounds(254, 49, 116, 41);
		panel.add(lblNewLabel);
		
		orderIdtextField = new JTextField();
		orderIdtextField.setBounds(380, 47, 209, 45);
		panel.add(orderIdtextField);
		orderIdtextField.setColumns(10);
		
		JLabel itemLabel = new JLabel("Item");
		itemLabel.setBounds(254, 101, 116, 41);
		panel.add(itemLabel);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setBounds(254, 157, 116, 41);
		panel.add(lblQuantity_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(380, 153, 209, 45);
		panel.add(textField);
		
		itemCombo = new JComboBox(itemFactoryList.toArray());
		itemCombo.setBounds(380, 101, 209, 41);
		itemCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fetchSelectedItem(e);
			}
		});
		itemCombo.setBounds(342, 100, 220, 39);
		panel.add(itemCombo);
		panel.add(itemCombo);
		
		JLabel supplierLabel = new JLabel("Supplier");
		supplierLabel.setBounds(254, 211, 116, 41);
		panel.add(supplierLabel);
		
		JComboBox supplierCombo = new JComboBox();
		supplierCombo.setBounds(380, 209, 209, 45);
		panel.add(supplierCombo);
		
		JButton purchaseOrderBtn = new JButton("Purchase Order");
		purchaseOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeOrder(e);
			}
		});
		purchaseOrderBtn.setBounds(287, 275, 275, 36);
		panel.add(purchaseOrderBtn);
		
		JButton addItemToOrderBtn = new JButton("Add Item");
		addItemToOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemToOrderActionPerformed(e);
			}
		});
		addItemToOrderBtn.setBounds(605, 101, 127, 30);
		panel.add(addItemToOrderBtn);
		frame.setVisible(true);
	}
	
//	private void fetchSelectedItem(ActionEvent e) {
//		AbstractItemFactory selctedItem = (AbstractItemFactory)itemCombo.getSelectedItem();
//		for(AbstractItemFactory item: itemFactoryList) {
//			if(item.getObject().getItemName().equals(selctedItem.getObject().getItemName())) {
//				populateTextFields(selctedItem);
//			}
//		}
//	}
	
	public void placeOrder(ActionEvent e) {
		
	}
	
	private void addItemToOrderActionPerformed(ActionEvent e) {
		System.out.println("Adding item to order code would come here");
	}
}
