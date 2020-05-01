package com.test;

import java.util.ArrayList;

import com.revature.accounts.Account;
import com.revature.users.Customer;

public class SampleAccount {
	
	
	public static SampleCustomer one = new SampleCustomer();
	
	public static Account sample1(){
		Account sample1 = new Account();
		ArrayList<Customer> accountHolder = new ArrayList<>();
		accountHolder.add(one.sample1());
		accountHolder.add(one.sample2());
		sample1.setAccountStatus("Pending"); 
		sample1.setBalance(100);
		sample1.setAccountHolder(accountHolder);
//		sample1.setAccountNumber(999);
		return sample1;
	}
}