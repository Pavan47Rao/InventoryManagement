package edu.neu.csye7374.gui.inventory_mgr;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import edu.neu.csye7374.adapter.Calculator;
import edu.neu.csye7374.adapter.CalculatorAdapter;
import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.factories.AirpodsFactory;
import edu.neu.csye7374.gui.LogoutPage;
import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Stock;
import edu.neu.csye7374.singleton.AirpodsFactorySingleton;
import edu.neu.csye7374.singleton.CheeseFactorySingleton;
import edu.neu.csye7374.singleton.IphoneFactorySingleton;
import edu.neu.csye7374.singleton.MilkFactorySingleton;
import edu.neu.csye7374.singleton.PenFactorySingleton;
import edu.neu.csye7374.singleton.PencilFactorySingleton;
import edu.neu.csye7374.singleton.VRHeadsetFactorySingleton;
import edu.neu.csye7374.singleton.WritingPadFactorySingleton;
import edu.neu.csye7374.singleton.YogurtFactorySingleton;
import edu.neu.csye7374.stock.Dairy;
import edu.neu.csye7374.stock.Electronics;
import edu.neu.csye7374.stock.Stationary;
import edu.neu.csye7374.stock.StockRepository;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.awt.event.ActionEvent;

public class AddItemsPage {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField idField;
	private JTextField priceField;
	private JTextField qtyField;
	private JComboBox stockCombo,itemCombo;
	private JTextArea descPane;
	private List<AbstractItemFactory> itemFactoryList;
	private List<Item> itemList;

	
	public AddItemsPage(JFrame frame) {
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
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new LogoutPage(frame);
			}
		});
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
		 * Replace this code later on - SR
		 */
		List<Stock> stockList = new ArrayList<Stock>();
		Set<String> stockMapSet = StockRepository.stockMap.keySet();
		
		
		
		 stockCombo = new JComboBox(stockMapSet.toArray());
		stockCombo.setBounds(342, 249, 220, 34);
		panel.add(stockCombo);
		
		 descPane = new JTextArea();
		descPane.setBounds(342, 304, 220, 93);
		panel.add(descPane);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitItemActionPerformed(e);
			}
		});
		btnNewButton.setBounds(306, 419, 89, 23);
		panel.add(btnNewButton);
		
		 itemCombo = new JComboBox(itemFactoryList.toArray());
		itemCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchSelectedItem(e);
			}
		});
		itemCombo.setBounds(342, 100, 220, 39);
		panel.add(itemCombo);
		frame.setVisible(true);
	}
	
	private void fetchSelectedItem(ActionEvent e) {
		AbstractItemFactory selctedItem = (AbstractItemFactory)itemCombo.getSelectedItem();
		for(AbstractItemFactory item: itemFactoryList) {
			if(item.getObject().getItemName().equals(selctedItem.getObject().getItemName())) {
				populateTextFields(selctedItem);
			}
		}
	}
	
	private void populateTextFields(AbstractItemFactory selectedItem) {
		idField.setText(String.valueOf(selectedItem.getObject().getItemId()));
		priceField.setText(String.valueOf(selectedItem.getObject().getItemPrice()));
		descPane.setText(selectedItem.getObject().getItemDescription());
	}
	
	private void submitItemActionPerformed(ActionEvent e) {
		

		if(allFieldsArePopulated()) {
		
			
			checkIfItemIsPresentInListAlready(Integer.parseInt(idField.getText()));
			
			
		}
	}
	
	private boolean allFieldsArePopulated() {
		if(idField.getText().equals("") || priceField.getText().equals("") || qtyField.getText().equals("") || descPane.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	private void checkIfItemIsPresentInListAlready(int itemId) {
		
		AbstractItemFactory selctedItem = (AbstractItemFactory)itemCombo.getSelectedItem();
		String selectedStock = (String)stockCombo.getSelectedItem();
		
		Calculator cal = new Calculator();
		CalculatorAdapter adpater = new CalculatorAdapter(cal);
		boolean itemFound = false;
		if(MainFrame.getInventoryManager().getItems().size() == 0) {
			addItem(selctedItem, selectedStock);
		} else {
			for(ListIterator<Item> itr = MainFrame.getInventoryManager().getItems().listIterator();itr.hasNext();) {
				Item i = itr.next();
				if(i.getItemId() == itemId) {
					
					i.setItemQuantity(adpater.updateQuantity(i, Integer.parseInt(qtyField.getText())));
					JOptionPane.showMessageDialog(panel, selctedItem.getObject().getItemName()+" already exist in the list. Updated quantity in inventory: "+i.getItemQuantity());
					itemFound = true;
				}
			}
			
			if(!itemFound) {
			addItem(selctedItem, selectedStock);		
			}
		}
		
	}
	
	private void addItem(AbstractItemFactory selctedItem, String selectedStock) {
		Item addItem = new Item();
		addItem.setItemId(Integer.parseInt(idField.getText()));
		addItem.setItemName(selctedItem.getObject().getItemName());
		addItem.setItemPrice(Double.parseDouble(priceField.getText()));
		addItem.setItemQuantity(Integer.parseInt(qtyField.getText()));
		addItem.setStock(StockRepository.getStock(selectedStock));
		addItem.setItemDescription(descPane.getText());
		
		StockRepository.getStock(selectedStock).addItemToStock(addItem);
		
		MainFrame.getInventoryManager().addItems(addItem);
		JOptionPane.showMessageDialog(panel, qtyField.getText()+" "+selctedItem.getObject().getItemName()+" has been successfully added to the inventory");
	}
}
