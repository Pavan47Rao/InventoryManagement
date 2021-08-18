package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.fileUtilities.FileWriterReader;
import edu.neu.csye7374.gui.LogoutPage;
import edu.neu.csye7374.singleton.AirpodsFactorySingleton;
import edu.neu.csye7374.singleton.CheeseFactorySingleton;
import edu.neu.csye7374.singleton.IphoneFactorySingleton;
import edu.neu.csye7374.singleton.MilkFactorySingleton;
import edu.neu.csye7374.singleton.PenFactorySingleton;
import edu.neu.csye7374.singleton.PencilFactorySingleton;
import edu.neu.csye7374.singleton.VRHeadsetFactorySingleton;
import edu.neu.csye7374.singleton.WritingPadFactorySingleton;
import edu.neu.csye7374.singleton.YogurtFactorySingleton;

public class ManageOrderPage {
	private JFrame frame;
	private JPanel panel;
	private JTextField orderIdtextField;
	private JTextField textField;
	private List<AbstractItemFactory> itemFactoryList;
	private FileWriterReader file;
	
	public ManageOrderPage(JFrame frame) throws ClassNotFoundException, IOException {
		this.frame = frame;
		itemFactoryList = new ArrayList<AbstractItemFactory>();
		file = new FileWriterReader();
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new LogoutPage(frame);
			}
		});
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
		itemLabel.setBounds(254, 101, 72, 41);
		panel.add(itemLabel);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setBounds(254, 170, 116, 41);
		panel.add(lblQuantity_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(380, 166, 209, 45);
		panel.add(textField);
		
		JLabel supplierLabel = new JLabel("Supplier");
		supplierLabel.setBounds(254, 224, 116, 41);
		panel.add(supplierLabel);
		
		JComboBox supplierCombo = new JComboBox();
		supplierCombo.setBounds(380, 222, 209, 45);
		panel.add(supplierCombo);
		
		JButton purchaseOrderBtn = new JButton("Purchase Order");
		purchaseOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeOrder(e);
			}
		});
		purchaseOrderBtn.setBounds(287, 288, 275, 36);
		panel.add(purchaseOrderBtn);
		
		JButton addItemToOrderBtn = new JButton("Add Item");
		addItemToOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemToOrderActionPerformed(e);
			}
		});
		addItemToOrderBtn.setBounds(641, 101, 127, 30);
		panel.add(addItemToOrderBtn);
		
		JComboBox comboBox = new JComboBox(itemFactoryList.toArray());
		comboBox.setBounds(380, 103, 213, 45);
		panel.add(comboBox);
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
