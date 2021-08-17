package edu.neu.csye7374.api;

import edu.neu.csye7374.model.Account;

public interface ResetPasswordAPI {
	Account resetPassword(Account account, String keywordOrNewPassword);
}
