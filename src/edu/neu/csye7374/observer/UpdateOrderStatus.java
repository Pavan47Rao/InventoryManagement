package edu.neu.csye7374.observer;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.neu.csye7374.api.ObserverAPI;
import edu.neu.csye7374.api.SubjectAPI;
import edu.neu.csye7374.model.InventoryManager;
import edu.neu.csye7374.model.Order;
import edu.neu.csye7374.model.Supplier;

public class UpdateOrderStatus implements ObserverAPI{

	SubjectAPI observable;
	
	public UpdateOrderStatus(SubjectAPI observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	@Override
	public void update(Order order, InventoryManager inventoryManager, Supplier supplier) {
		if(order.getStatus().equals("requested")) {
			supplier.getOrders().add(order);
			sendEmail(supplier.getAccount().getUserName(), "New order placed", "Inventory Manager "+ inventoryManager.getFirstName()+" has placed a new order "+order.getOrderId());
		}
		else if(order.getStatus().equals("approved")) {
			inventoryManager.getOrders().add(order);
			sendEmail(inventoryManager.getAccount().getUserName(), "Order ready", "Supplier "+ supplier.getFirstName()+" has approved your order "+order.getOrderId());

		}
	}
	
	public static String sendEmail(String to,String msg, String subject){
        
        String toEmail = to;
        String fromEmail="neudesignpatterns@gmail.com";
        
        Properties properties=new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        Session session=Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication(){
                
                return new PasswordAuthentication(fromEmail, "NEUdesignpatterns2021");  
            }
        });
        
        try{
            
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setText(msg);
            Transport.send(message);
            System.out.println("Sending email to "+ to+ " Successful!");
            return "successfull";
            
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null, "Invalid email!");
            System.out.println("Sending email to "+ to+ " Failed ::"+ ex.toString());
            return "unsuccessful";
            
        }
    }

}
