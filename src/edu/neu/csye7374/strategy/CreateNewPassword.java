package edu.neu.csye7374.strategy;

import edu.neu.csye7374.api.ResetPasswordAPI;
import edu.neu.csye7374.model.Account;

public class CreateNewPassword implements ResetPasswordAPI{

	@Override
	public String resetPassword(Account account, String newPassword) {
		// TODO Auto-generated method stub
		account.resetPassword(newPassword);
		return newPassword;
	}
	
}
