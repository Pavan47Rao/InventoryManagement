package edu.neu.csye7374.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye7374.fileUtilities.FileWriterReader;
import edu.neu.csye7374.model.HR;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Person;
import edu.neu.csye7374.model.Supplier;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class HumanResourcesHomePage {
	
	private JFrame frame;
	private JPanel panel;
	
	public HumanResourcesHomePage(JFrame frame) throws ClassNotFoundException, IOException {
		this.frame = frame;
		prepareGUI();
	}
	
	private void prepareGUI() throws ClassNotFoundException, IOException {
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				new LogoutPage(frame);
			}
		});
		logoutBtn.setBounds(645, 11, 89, 23);
		panel.add(logoutBtn);
		
		DefaultTableModel model = loadTable();
		
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(158, 52, 632, 337);
		panel.add(scrollPane);
		
		JLabel headerLabel = new JLabel("Human Resources Home Page");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		headerLabel.setBounds(158, 15, 444, 14);
		panel.add(headerLabel);
		
		JButton addBtn = new JButton("Add Users");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUserActionPerformed(e);
			}
		});
		addBtn.setBounds(10, 166, 138, 63);
		panel.add(addBtn);
		
		frame.setVisible(true);
	}
	
	private void addUserActionPerformed(ActionEvent e) {
	
		frame.getContentPane().removeAll();
		new HumanResourceAddUserPage(frame);
	}
	
	private DefaultTableModel loadTable() throws ClassNotFoundException, IOException {
		String[] columns = {"ID", "Role", "First Name", "Last Name", "Email ID", "Date of Birth", "Address" };
	      List<String[]> values = new ArrayList<String[]>();
	      
	      FileWriterReader fileUtil = new FileWriterReader();
	      List<Person> personList = fileUtil.loadPersons();
	      List<InventoryManager> managers = fileUtil.loadManagers();
	      List<HR> hrs = fileUtil.loadHRs();
	      List<Supplier> supps = fileUtil.loadSupplier();
	      
	      for(Person p: personList) {
	    	  values.add(new String[] {
	    			  String.valueOf(p.getPersonId()),
	    			String.valueOf(p.getRoleId()),
	    			p.getFirstName(),
	    			p.getLastName(),
	    			p.getEmailId(),
	    			p.getDob().toString(),
	    			p.getAddress()
	    			  
	    	  });
	      }
	      for(InventoryManager p: managers) {
	    	  values.add(new String[] {
	    			  String.valueOf(p.getPersonId()),
	    			  String.valueOf(p.getRoleId()),
	    			  p.getFirstName(),
	    			  p.getLastName(),
	    			  p.getEmailId(),
	    			  p.getDob().toString(),
	    			  p.getAddress()
	    			  
	    	  });
	      }
	     
	      for(HR p: hrs) {
	    	  values.add(new String[] {
	    			  String.valueOf(p.getPersonId()),
	    			  String.valueOf(p.getRoleId()),
	    			  p.getFirstName(),
	    			  p.getLastName(),
	    			  p.getEmailId(),
	    			  p.getDob().toString(),
	    			  p.getAddress()
	    			  
	    	  });
	      }
	      
	      for(Supplier p: supps) {
	    	  values.add(new String[] {
	    			  String.valueOf(p.getPersonId()),
	    			  String.valueOf(p.getRoleId()),
	    			  p.getFirstName(),
	    			  p.getLastName(),
	    			  p.getEmailId(),
	    			  p.getDob().toString(),
	    			  p.getAddress()
	    			  
	    	  });
	      }
	      
	      
	        
	        DefaultTableModel model = new DefaultTableModel(values.toArray(new Object[][] {}), columns);
		
		return model;
	}
	
	
}
