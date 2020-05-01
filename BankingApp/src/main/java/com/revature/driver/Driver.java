package com.revature.driver;

import java.util.ArrayList;

import com.revature.accounts.Account;
import com.revature.bank.Bank;
import com.revature.menu.AdminMenu;
import com.revature.menu.CustomerMenu;
import com.revature.menu.EmployeeMenu;
import com.revature.menu.Menu;
import com.revature.services.AccountServices;
import com.revature.services.BankServices;
import com.revature.services.CustomerServices;
import com.revature.users.Customer;

public class Driver {

	public static void main(String[] args) {
		//Create bank object and pull all bank info from documents
		Bank bank = new Bank();
		bank.pullAllBankInfo();
		Menu m = new Menu();
		m.runMenu();
		

		
		//CustomerMenu c = new CustomerMenu("Brad", "Mark");
		//c.accountMenu();LOLO
//		CustomerServices.listAllCustomers();
//		AccountServices.listAllAccounts();
//		System.out.println(Bank.getAccounts());
//		System.out.println(AccountServices.getAccount(1000));
//		AccountServices.addToAccount(1000, CustomerServices.getCustomer("Brad"));
//		System.out.println(AccountServices.getAccount(1000));
//		AccountServices.changePendingAccount(AccountServices.getAccount(1001), true);
//		AccountServices.checkPendingAccount();
//		AdminMenu.runAdminMenu();
//		//example customer
//		Customer exampleCustomer = new Customer("Brad","Mark");
		
//		System.out.println(exampleCustomer);
		//example account
//		ArrayList<Customer> accountHolders = new ArrayList<>();
//		accountHolders.add(exampleCustomer);
//		double initialBalance = 1000000.00;
//		Account exampleAccount = new Account();
//		System.out.println(exampleAccount.getAccountHolder());
		
//		BankServices.withdraw(AccountServices.getAccount(1000), 10);
//		BankServices.deposit(AccountServices.getAccount(1000), 20);
//		System.out.println(exampleAccount.getBalance());	
//		BankServices.transfer(AccountServices.getAccount(1002), AccountServices.getAccount(1001), 100);
		
//		CustomerServices.addCustomer(exampleCustomer);
//		AccountServices.addPendingAccount(exampleAccount);
//		bank.pullAllBankInfo();
//		System.out.println(CustomerServices.getCustomer("customerName"));
		
	}
	
	public static class EveryColorText {
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";
		
		public static String[] allColors = {ANSI_BLACK,ANSI_BLUE,ANSI_CYAN,ANSI_GREEN,ANSI_PURPLE,ANSI_RED,ANSI_WHITE,ANSI_YELLOW};
		
		public static void rainbow(String text) {
			char[] charArr = text.toCharArray();
//			String coloredString=text;
			int color = 3;
			for(char c : charArr) {
				System.out.print(allColors[color]+String.valueOf(c));
				if(color == allColors.length-1) { color =0; } else { color++; };
			}
		}
	}
		
}