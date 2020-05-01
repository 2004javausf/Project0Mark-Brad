package com.revature.accounts;

import java.io.Serializable;
import java.util.ArrayList;

import com.revature.bank.Bank;
import com.revature.users.Customer;


public class Account implements Serializable{
	private static final long serialVersionUID = -576684925217400380L;
	private double balance;
	private String accountStatus;
	private String accountType;
	private ArrayList<Customer> accountHolder;
	private int accountNumber;
	
	public Account() {
		super();
		this.balance = 0;
		this.accountHolder = new ArrayList<Customer>();
		this.accountNumber = nextAccountNumber();
		this.accountStatus = "Pending";
	}
	
	public Account(double initialDeposit, ArrayList<Customer> accountHolder){
		this.accountStatus = "Pending";
		this.balance = initialDeposit;
		this.accountHolder = accountHolder;
		this.accountNumber = nextAccountNumber();
	}
	
	private int nextAccountNumber() {
		int nextNumber = Bank.getAccountNumCount();
		Bank.incAccountNumCount();
		return nextNumber;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
//AccountType if we want to differentiate between checking and saving
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public ArrayList<Customer> getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(ArrayList<Customer> accountHolder) {
		this.accountHolder = accountHolder;
	}
	

	@Override
	public String toString() {
		String accountHolderNames = "";
		for(Customer i: accountHolder) {
			accountHolderNames += i.getUsername() +" ";
		}
		
		return "\n\tAccount Number: "+accountNumber+", Holder(s): " +accountHolderNames+
				", balance: "+ balance +", Account status: "+accountStatus+"\n";
	}

	
	
	
	
}