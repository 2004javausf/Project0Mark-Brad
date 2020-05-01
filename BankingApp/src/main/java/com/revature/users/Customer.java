package com.revature.users;

import java.io.Serializable;
import java.util.ArrayList;

import com.revature.accounts.Account;
import com.revature.bank.Bank;
import com.revature.services.CustomerServices;

public class Customer implements Serializable{

	private static final long serialVersionUID = -4681026638434820379L;
	private  final static String customerFile="Customers.txt";
	private static String userType = "Customer";
	private String username;
	private String password;
	
	public Customer() {
		super();
	}

	public Customer(String username, String password){
		super();
		this.username = username;
		this.password = password;
	}

	public static String getUserType() {
		return userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		ArrayList<Account> accounts = CustomerServices.getCustomerAccounts(this);
		return "Customer Username: " +username+
				", Password: "+ password+
				", Accounts " + accounts +"\n";
	}

}