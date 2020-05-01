package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.revature.accounts.Account;
import com.revature.bank.Bank;
import com.test.SampleAccount;
import com.test.SampleCustomer;
import com.revature.services.AccountServices;
import com.revature.users.Customer;

class AccountServicesTests {
	Customer customer = new SampleCustomer().sample1();
	Account account = new SampleAccount().sample1();
	ArrayList<Account> accArray = (ArrayList<Account>) Arrays.asList(account);
//	Bank bank = new Bank(account.getAccountHolder(),accArray);

	
	@Test
	void testGetAccount() {
		int accountNum = 999;
		assertEquals(account, AccountServices.getAccount(accountNum));
	}

	@Test
	void testListAllAccounts() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPendingAccountDoubleAccountString() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPendingAccountDoubleCustomerArray() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPendingAccountDoubleStringArray() {
		fail("Not yet implemented");
	}

	@Test
	void testAddToAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testChangePendingAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckPendingAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testShowPendingAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveAccountAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveAccountInt() {
		fail("Not yet implemented");
	}

}