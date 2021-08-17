package edu.neu.csye7374.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		
		JButton generatePwdBtn = new JButton("Generate New Password");
		generatePwdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutoGeneratePassword newPwd = new AutoGeneratePassword();
				Context context = new Context(newPwd);
				context.performReset(MainFrame.getLoggedInPerson().getAccount(), "");
				JOptionPane.showMessageDialog(panel, "New password created: "+MainFrame.getLoggedInPerson().getAccount().getPassword());
			}
		});
		generatePwdBtn.setBounds(397, 126, 200, 29);
		panel.add(generatePwdBtn);
		
		JButton createPwdBtn = new JButton("Create your own password");
		createPwdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPasswordValue.setEnabled(true);
				submitBtn.setEnabled(true);
			}
		});
		createPwdBtn.setBounds(89, 126, 200, 29);
		panel.add(createPwdBtn);
		
		emailIdValue = new JTextField();
		emailIdValue.setBounds(217, 67, 130, 26);
		panel.add(emailIdValue);
		emailIdValue.setColumns(10);
		
		newPasswordValue = new JTextField();
		newPasswordValue.setBounds(217, 185, 130, 26);
		newPasswordValue.setEnabled(false);
		panel.add(newPasswordValue);
		newPasswordValue.setColumns(10);
		
		JLabel pwdInstructionLabel = new JLabel("<html>Password should contain <br>atleast 1 upper case, <br>1 lower case, <br>1 special character, <br>1 number <br>and total of 8 characters</html>");
		pwdInstructionLabel.setBounds(33, 220, 170, 104);
		panel.add(pwdInstructionLabel);
		
		JLabel newPwdLabel = new JLabel("New Password");
		newPwdLabel.setBounds(71, 190, 100, 16);
		panel.add(newPwdLabel);
		
		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewPassword newPwd = new CreateNewPassword();
				Context context = new Context(newPwd);
				context.performReset(MainFrame.getLoggedInPerson().getAccount(), newPasswordValue.getText());
				JOptionPane.showMessageDialog(panel, "Updated password successfully");
			}
		});
		submitBtn.setBounds(229, 236, 117, 29);
		submitBtn.setEnabled(false);
		panel.add(submitBtn);
		frame.setVisible(true);
	
	}
}
