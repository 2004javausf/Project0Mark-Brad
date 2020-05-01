package com.revature.services;

import com.revature.accounts.Account;
import com.revature.bank.Bank;

public class BankServices {
	
	public static void withdraw(Account account, double Withdrawl) {
		if (account.getAccountStatus().equals("Active")) {
			if (Withdrawl <= 0) {
				System.out.println("You must enter a positive withdrawl");
			} else {
				if (account.getBalance() < Withdrawl) {
					System.out.println("Insufficient funds");
				} else {
					double Balance = account.getBalance();
					double NewBalance = Balance -= Withdrawl;
					account.setBalance(NewBalance);
					System.out.println("Your new balance is: " + NewBalance);
					Bank.pushAllBankInfo();
				}
			}
		} else {
			System.out.println("Sorry you cannot complete this action until your account is approved");
		}
	}
	

	public static void deposit(Account account, double Deposit) {
		if (Deposit <= 0) {
			System.out.println("You must enter a positive deposit");
		} else {
			if (account.getAccountStatus().equals("Active")) {

				double Balance = account.getBalance();
				double NewBalance = Balance += Deposit;
				account.setBalance(NewBalance);
				System.out.println("Your new balance is: " + NewBalance);
				Bank.pushAllBankInfo();
			} else {
				System.out.println("Sorry you cannot complete this action until your account is approved");
			}
		}
	}
	
	public static void transfer(Account out, Account in, double transfer) {
		if (transfer > 0) {
			if (out.getAccountStatus().equals("Active") && in.getAccountStatus().equals("Active")) {
				if (out.getBalance() < transfer) {
					System.out.println("Insufficient funds");
				} else {
					double BalanceOut = out.getBalance();
					double BalanceIn = in.getBalance();
					BalanceOut -= transfer;
					BalanceIn += transfer;
					out.setBalance(BalanceOut);
					in.setBalance(BalanceIn);
					System.out.println("Your balance in " + out.getAccountNumber() + " is: " + out.getBalance());
					System.out.println("Your balance in " + in.getAccountNumber() + " is: " + in.getBalance());
					Bank.pushAllBankInfo();
				}
			} else {
				System.out.println("Sorry you cannot complete this action until both accounts are approved");
			}
		} else
			System.out.println("You must enter a positive number to transfer");
	}
}