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
import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Order;
import edu.neu.csye7374.model.Person;
import edu.neu.csye7374.model.Supplier;
import edu.neu.csye7374.observer.PlaceOrder;
import edu.neu.csye7374.observer.UpdateOrderStatus;
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
	private JTextField qtyTextField;
	private List<AbstractItemFactory> itemFactoryList;
	private JComboBox itemCombo, supplierCombo;
	private FileWriterReader file;
	private List<String> suppliers;
	
	public ManageOrderPage(JFrame frame) throws ClassNotFoundException, IOException {
		this.frame = frame;
		itemFactoryList = new ArrayList<AbstractItemFactory>();
		file = new FileWriterReader();
		loadSuppliers();
		populateItemList(itemFactoryList);
		prepareGUI();
	}
	
	private void loadSuppliers() {
		suppliers = new ArrayList<>();
		try {
			for(Person supplier: file.loadSupplier()) {
				suppliers.add(supplier.getFirstName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		qtyTextField = new JTextField();
		qtyTextField.setColumns(10);
		qtyTextField.setBounds(380, 166, 209, 45);
		panel.add(qtyTextField);
		
		JLabel supplierLabel = new JLabel("Supplier");
		supplierLabel.setBounds(254, 224, 116, 41);
		panel.add(supplierLabel);
		
		supplierCombo = new JComboBox(suppliers.toArray());
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
		
		itemCombo = new JComboBox(itemFactoryList.toArray());
		itemCombo.setBounds(380, 103, 213, 45);
		panel.add(itemCombo);
		frame.setVisible(true);
	}
	
	public void placeOrder(ActionEvent e) {
		FileWriterReader fileUtil;
		try {
			fileUtil = new FileWriterReader();
			List<InventoryManager> IM = fileUtil.loadManagers();
			Order order = new Order();
			AbstractItemFactory selectedItem = (AbstractItemFactory)itemCombo.getSelectedItem();
			order.setItems(new ArrayList<>());
			order.getItems().add(selectedItem.getObject());
			order.setOrderId(Integer.valueOf(orderIdtextField.getText()));
			order.setQuantity(Integer.parseInt(qtyTextField.getText()));
			order.setStatus("requested");
			InventoryManager managerOfOrder = null;
			for(InventoryManager p: IM) {
				if(MainFrame.getLoggedInPerson().getAccount().getUserName().equals(p.getAccount().getUserName())) {
					order.setInventoryManager(p);
					managerOfOrder = p;
//					p.getOrders().add(order);
					break;
				}	
			}
			Supplier supplierOfOrder = null;
			for(Supplier supplier: fileUtil.loadSupplier()) {
 				if(supplier.getFirstName().equals(supplierCombo.getSelectedItem().toString())) {
					order.setSupplier(supplier);
					supplierOfOrder = supplier;
//					supplier.getOrders().add(order);
					break;
 				}
			}
			PlaceOrder obj = new PlaceOrder();
			UpdateOrderStatus obj2 = new UpdateOrderStatus(obj);
			obj.notifyObserver(order, managerOfOrder, supplierOfOrder);
//			fileUtil = new FileWriterReader(MainFrame.getCompany());
//			fileUtil.saveAll();
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
}
