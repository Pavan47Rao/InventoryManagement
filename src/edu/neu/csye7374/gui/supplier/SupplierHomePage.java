package edu.neu.csye7374.gui.supplier;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye7374.api.AbstractItemFactory;
import edu.neu.csye7374.fileUtilities.FileWriterReader;
import edu.neu.csye7374.gui.LogoutPage;
import edu.neu.csye7374.gui.MainFrame;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Item;
import edu.neu.csye7374.model.Order;
import edu.neu.csye7374.model.Stock;
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

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SupplierHomePage {
	
	private JFrame frame;
	private JPanel panel;
	private FileWriterReader fileUtil;
	private JTable table;
	private List<AbstractItemFactory> itemFactoryList;
	
	public SupplierHomePage(JFrame frame) {
		this.frame = frame;
		itemFactoryList = new ArrayList<AbstractItemFactory>();
		populateItemList(itemFactoryList);
		try {
			init();
			prepareGUI();
			
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void init() throws ClassNotFoundException, IOException {
		this.fileUtil = new FileWriterReader(MainFrame.getCompany());
	}
	
	private void prepareGUI() throws ClassNotFoundException, IOException {
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Supplier Home Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(214, 11, 295, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new LogoutPage(frame);
			}
		});
		btnNewButton.setBounds(629, 8, 89, 23);
		panel.add(btnNewButton);
		
		DefaultTableModel model = loadTable();
		 table = new JTable(model);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(103, 65, 530, 255);
		panel.add(scrollPane);
		
		JButton completeOrderBtn = new JButton("Fulfil Order");
		completeOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				completeOrderActionPerfomed(e);
			}
		});
		completeOrderBtn.setBounds(257, 346, 196, 43);
		panel.add(completeOrderBtn);
		frame.setVisible(true);
	}
	
	private DefaultTableModel loadTable() throws ClassNotFoundException, IOException {
		String[] columns = {"Order ID", "Item", "Quantity", "Inventory Manager"};
	      List<String[]> values = new ArrayList<String[]>();
	      
	     List<Supplier> supplierList = this.fileUtil.loadSupplier();
	     for(Supplier s: supplierList) {
	    	 if(s.getAccount().getUserName().equals(MainFrame.getLoggedInPerson().getAccount().getUserName())) {
	    		 List<Order> orderList = s.getOrders();
	    		 System.out.println("This is the order list size:"+orderList.size());
	    		 for(Order o: orderList) {
	    			 values.add(new String[] {String.valueOf(o.getOrderId()),
	    					 o.getItems().get(0).getItemName(),
	    					 String.valueOf(o.getQuantity()),
	    					 o.getInventoryManager().getFirstName()});
	    		 }
	    	 }
	     }
	      
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
	}
	
	private int getIndexOfInventoryManager(String firstName) {
		
		for(InventoryManager im: MainFrame.getCompany().getManagers()) {
			if(im.getFirstName().equals(firstName)) {
				return MainFrame.getCompany().getManagers().indexOf(im);
			}
		}
		return 0;
	}
	
	private Item getIndexOfItem(String itemName) {
			for(AbstractItemFactory i: itemFactoryList) {
				if(i.getObject().getItemName().equals(itemName)) {
					return i.getObject();
				}
			}
			return null;
	}
	
	private Supplier getSupplierObject() {
		for(Supplier s: MainFrame.getCompany().getSuppliers()) {
			if(s.getAccount().getUserName().equals(MainFrame.getLoggedInPerson().getAccount().getUserName())) {
				return s;
			}
		}
		return null;
	}
	
	private void completeOrderActionPerfomed(ActionEvent e) {
	
		if(table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(panel, "Please select an entry from the table");
		} else {
			Order fulfilledOrder = new Order();
			fulfilledOrder.setOrderId(Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0)));
			fulfilledOrder.setItems(new ArrayList<>());
			fulfilledOrder.getItems().add(getIndexOfItem((String)table.getValueAt(table.getSelectedRow(), 1)));
			
			fulfilledOrder.setStatus("approved");
			fulfilledOrder.setQuantity(Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 2)));
			int index = getIndexOfInventoryManager((String)table.getValueAt(table.getSelectedRow(), 3));
			fulfilledOrder.setInventoryManager(MainFrame.getCompany().getManagers().get(index));
			fulfilledOrder.setSupplier(getSupplierObject());
			
			PlaceOrder obj = new PlaceOrder();
			UpdateOrderStatus obj2 = new UpdateOrderStatus(obj);
			obj.notifyObserver(fulfilledOrder, MainFrame.getCompany().getManagers().get(index), getSupplierObject());
			
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

}
