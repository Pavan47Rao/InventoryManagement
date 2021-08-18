package edu.neu.csye7374.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.neu.csye7374.fileUtilities.FileWriterReader;
import edu.neu.csye7374.model.Account;
import edu.neu.csye7374.model.Person;
import edu.neu.csye7374.strategy.AutoGeneratePassword;
import edu.neu.csye7374.strategy.Context;
import edu.neu.csye7374.strategy.CreateNewPassword;

public class ResetPasswordPage {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField emailIdValue;
	private JTextField newPasswordValue;
	private JButton submitBtn;
	
	public ResetPasswordPage(JFrame frame) {
		this.frame = frame;
		panel = new JPanel();
		panel.setBounds(new Rectangle(800, 500));
		panel.setLayout(null);
		
		
		frame.getContentPane().add(panel);
		
		JLabel header = new JLabel("Reset Password");
		header.setBounds(229, 20, 100, 16);
		panel.add(header);
		
		JLabel emailIdLabel = new JLabel("Email Id");
		emailIdLabel.setBounds(89, 72, 100, 16);
		panel.add(emailIdLabel);
		
		emailIdValue = new JTextField();
		emailIdValue.setBounds(217, 67, 130, 26);
		panel.add(emailIdValue);
		emailIdValue.setColumns(10);
		
		JLabel newPwdLabel = new JLabel("New Password");
		newPwdLabel.setBounds(71, 190, 100, 16);
		panel.add(newPwdLabel);

		JLabel pwdInstructionLabel = new JLabel("<html>Password should contain <br>atleast 1 upper case, <br>1 lower case, <br>1 special character, <br>1 number <br>and total of 8 characters</html>");
		pwdInstructionLabel.setBounds(33, 220, 170, 104);
		panel.add(pwdInstructionLabel);
		
		newPasswordValue = new JTextField();
		newPasswordValue.setBounds(217, 185, 130, 26);
		newPasswordValue.setEnabled(false);
		panel.add(newPasswordValue);
		newPasswordValue.setColumns(10);
		
		JButton createPwdBtn = new JButton("Create your own password");
		createPwdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPasswordValue.setEnabled(true);
				submitBtn.setEnabled(true);
			}
		});
		createPwdBtn.setBounds(89, 126, 200, 29);
		panel.add(createPwdBtn);
		
		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc = getAccountByEmailId(emailIdValue.getText());
				if(acc == null) {
					JOptionPane.showMessageDialog(panel, "User not registered!");
				}
				else {
					CreateNewPassword newPwd = new CreateNewPassword();
					Context context = new Context(newPwd);
					Account updatedAccount = context.performReset(acc, newPasswordValue.getText());
					updateFile(updatedAccount);
					JOptionPane.showMessageDialog(panel, "Updated password successfully");
				}
			}
		});
		submitBtn.setBounds(229, 236, 117, 29);
		submitBtn.setEnabled(false);
		panel.add(submitBtn);
		frame.setVisible(true);
		
		JButton generatePwdBtn = new JButton("Generate New Password");
		generatePwdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account acc = getAccountByEmailId(emailIdValue.getText());
				if(acc == null) {
					JOptionPane.showMessageDialog(panel, "User not registered!");
				}
				else {
					AutoGeneratePassword newPwd = new AutoGeneratePassword();
					Context context = new Context(newPwd);
					Account updatedAccount = context.performReset(acc, "");
					updateFile(updatedAccount);
					JOptionPane.showMessageDialog(panel, "New password created: "+updatedAccount.getPassword());
				}
				
			}
		});
		generatePwdBtn.setBounds(397, 126, 200, 29);
		panel.add(generatePwdBtn);
		
		JButton backButton = new JButton("Back to Login");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				try {
					new MainFrame();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		backButton.setBounds(6, 15, 121, 29);
		panel.add(backButton);
	
	}
	
	private static Account getAccountByEmailId(String email) {
		try {
			FileWriterReader file = new FileWriterReader();
			for(Person person: file.loadPersons()) {
				if(person.getAccount().getUserName().equals(email))
					return person.getAccount();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	private static void updateFile(Account updatedAccount) {
		FileWriterReader fileUtil;
		try {
			for(Person person: MainFrame.getCompany().getPeople()) {
				if(person.getAccount().getUserName().equals(updatedAccount.getUserName()))
					person.getAccount().setPassword(updatedAccount.getPassword());
					System.out.println(person.getAccount().getPassword());
			}
			fileUtil = new FileWriterReader(MainFrame.getCompany());
			fileUtil.saveAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
