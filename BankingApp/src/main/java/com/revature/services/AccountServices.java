package com.revature.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import com.revature.accounts.Account;
import com.revature.bank.Bank;
import com.revature.users.Customer;

public class AccountServices {
//------------------------------------------------------------------
// AccountServices
//		.getAccount()
//		.listAllAccounts()
//		.addPendingAccount()
//		.changePendingStatus()
//		.removeAccount()
	
	public static Account getAccount(int accountNumber) {
		Iterator<Account> itr = Bank.getAccounts().iterator();
		while(itr.hasNext()) {
			Account currAccount = itr.next();
			if(currAccount.getAccountNumber()==accountNumber) {
				return currAccount;
			}
		}
		return null;
	}
	public static void listAllAccounts() {
		Iterator<Account> itr = Bank.getAccounts().iterator();
		System.out.println("All Accounts:");
		while(itr.hasNext()) {
			Account currAccount = itr.next();
			System.out.println("\t-"+currAccount.getAccountStatus()
				+"- AccountNum: "+currAccount.getAccountNumber());
		}
		System.out.println();
	}
	public static void addPendingAccount(double initialDeposit, Account newAccount, String accountType) {
		Bank.getAccounts().add(newAccount);
		newAccount.setAccountType(accountType);
		newAccount.setBalance(initialDeposit);
		System.out.println("Added account: " + newAccount.getAccountNumber()+"\n");
		Bank.pushAllBankInfo();
	}
	public static void addPendingAccount(double initalDeposit,Customer ...applicants ) {
		ArrayList<Customer> applicantList = new ArrayList<>();
		applicantList.add((Customer) Arrays.asList(applicants));
		Account newAccount = new Account(initalDeposit,applicantList);
		Bank.getAccounts().add(newAccount);
		System.out.println("Added account: " + newAccount.getAccountNumber()+"\n");
		Bank.pushAllBankInfo();
	}
	public static void addPendingAccount(double initalDeposit,String ...usernames ) {
		ArrayList<Customer> applicantList = new ArrayList<>();
		for(String applicant:usernames) {
			applicantList.add(CustomerServices.getCustomer(applicant));
		}
		Account newAccount = new Account(initalDeposit,applicantList);
		Bank.getAccounts().add(newAccount);
		System.out.println("Added account: " + newAccount.getAccountNumber()+"\n");
		Bank.pushAllBankInfo();
	}
	public static void addToAccount(int accountNumber, Customer customer) {
		Account account = getAccount(accountNumber);
		ArrayList<Customer> two = account.getAccountHolder();
		account.setAccountType("Pending");
		two.add(customer);
		account.setAccountHolder(two);
		Bank.pushAllBankInfo();
		System.out.println("Please wait for an employee or admin to approve your joint account");
	}
	public static void changePendingAccount(Account pendingAccount, boolean isApproved) {
		ListIterator<Account> itr = Bank.getAccounts().listIterator();
		boolean edited=false;
		try {
			while(itr.hasNext()) {
				Account currAccount = itr.next();
				if(currAccount.getAccountNumber() == pendingAccount.getAccountNumber()) {
					if(isApproved) {
						System.out.println("Approved account application \n\t"+pendingAccount.getAccountNumber()+" status is now 'Active'\n");
						currAccount.setAccountStatus("Active");
						edited = true;
					} else {
						System.out.println("Declined account application \n\t"+pendingAccount.getAccountNumber()+" status is now 'Declined'\n");
						currAccount.setAccountStatus("Declined");
						edited = true;
					}
					
				}
			}
		} catch (Exception e) {
			System.out.println("Could not find this account");
		}
		if(edited) {
			Bank.pushAllBankInfo();
		} else {
			System.out.println("Could not find this");
		}
	}
	
	public static void checkPendingAccount() {
		ListIterator<Account> itr = Bank.getAccounts().listIterator();
		while(itr.hasNext()) {
			Account currAccount = itr.next();
			if(currAccount.getAccountStatus().equals("Pending")) {
				System.out.println(currAccount.getAccountNumber());
			}
		}
	}
	
	public static void showPendingAccount() {
		ListIterator<Account> itr = Bank.getAccounts().listIterator();
		while(itr.hasNext()) {
			Account currAccount = itr.next();
			if(currAccount.getAccountStatus().equals("Pending")) {
				System.out.println(currAccount.getAccountHolder());
			}
		}
	}
	
	
	public static void removeAccount(Account existingAccount) {
		ListIterator<Account> itr = Bank.getAccounts().listIterator();
		try {
			while(itr.hasNext()) {
				Account currAccount = itr.next();
				if(currAccount.getAccountNumber() == existingAccount.getAccountNumber()) {
					System.out.println("Removed account "+existingAccount.getAccountNumber()+"\n");
					itr.remove();
					Bank.pushAllBankInfo();
				}
			}
		} catch (Exception e) {
			System.out.println("Could not remove Account\n");
		}
	}
	public static void removeAccount(int accountNumber) {
		ListIterator<Account> itr = Bank.getAccounts().listIterator();
		try {
			while(itr.hasNext()) {
				Account currAccount = itr.next();
				if(currAccount.getAccountNumber() == accountNumber) {
					System.out.println("Removed account "+accountNumber+"\n");
					itr.remove();
					Bank.pushAllBankInfo();
				}
			}
		} catch (Exception e) {
			System.out.println("Could not remove Account\n");
		}
	}
}