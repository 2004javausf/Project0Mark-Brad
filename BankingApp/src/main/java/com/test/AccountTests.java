package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.test.SampleAccount;
import com.revature.users.Customer;

class AccountTests {
	SampleAccount account = new SampleAccount();
	ArrayList<Customer> accountHolder = com.test.SampleAccount.sample1().getAccountHolder();
	
	private String runToString() {
		String accountHolderNames = "";
		for(Customer i: accountHolder) {
			accountHolderNames += i.getUsername() +" ";
		}
		return accountHolderNames;
//		return "\n\tAccount Number: "+accountNumber+", Holder(s): " +accountHolderNames+
//				", balance: "+ balance +", Account status: "+accountStatus+"\n";
	}
	
	@Test
	void testToString() {
		assertEquals(new String("username1 username2 "), runToString());
	}

	

}