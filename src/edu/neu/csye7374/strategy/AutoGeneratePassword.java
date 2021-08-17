package edu.neu.csye7374.strategy;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.neu.csye7374.api.ResetPasswordAPI;
import edu.neu.csye7374.model.Account;

public class AutoGeneratePassword implements ResetPasswordAPI{

	private final SecureRandom randomNo = new SecureRandom();
	 
	private final List<Character> passwordObj;
	
	public AutoGeneratePassword() {
		passwordObj = new ArrayList<>();
		
		// Adding ASCII Decimal value between 33 and 53
        for (int i = 33; i < 53; i++) {
        	passwordObj.add((char) i);
        }
 
        // Adding ASCII Decimal value between 54 and 85
        for (int i = 54; i < 85; i++) {
        	passwordObj.add((char) i);
        }
 
        // Adding ASCII Decimal value between 86 and 128
        for (int i = 86; i < 127; i++) {
        	passwordObj.add((char) i);
        }
        
        Collections.rotate(passwordObj, 5);
	}
	
	public char getRandom() {
		char crunchifyChar = this.passwordObj.get(randomNo.nextInt(this.passwordObj.size()));
        return crunchifyChar;
    }
	
	@Override
	public String resetPassword(Account account, String keyword) {
		AutoGeneratePassword passwordGenerator = new AutoGeneratePassword();
        StringBuilder pwd = new StringBuilder();
            
        for (int length = 0; length < 15; length++) {
            pwd.append(passwordGenerator.getRandom());
        }
		
        return pwd.toString();
	}

}
