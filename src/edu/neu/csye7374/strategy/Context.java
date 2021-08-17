package edu.neu.csye7374.strategy;

import edu.neu.csye7374.api.ResetPasswordAPI;
import edu.neu.csye7374.model.Account;

public class Context {

	private ResetPasswordAPI resetPwd;

	public void setResetPwd(ResetPasswordAPI resetPwd) {
		this.resetPwd = resetPwd;
	}

	public Context(ResetPasswordAPI resetPwd) {
		this.resetPwd = resetPwd;
	}
	
	public Account performReset(Account account, String keyOrPassword) {
		return resetPwd.resetPassword(account, keyOrPassword);
	}
	
}
