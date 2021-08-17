package edu.neu.csye7374.strategy;

import edu.neu.csye7374.api.ResetPasswordAPI;
import edu.neu.csye7374.model.Account;

public class Context {

	private ResetPasswordAPI resetPwd;

	public void setViewBill(ResetPasswordAPI resetPwd) {
		this.resetPwd = resetPwd;
	}

	public Context(ResetPasswordAPI resetPwd) {
		this.resetPwd = resetPwd;
	}
	
	public String displayBillItems(Account account, String keyOrPassword) {
		return resetPwd.resetPassword(account, keyOrPassword);
	}
	
}
