package edu.neu.csye7374.api;

import edu.neu.csye7374.model.Account;

public interface ResetPasswordAPI {
	String resetPassword(Account account, String keywordOrNewPassword);
}
