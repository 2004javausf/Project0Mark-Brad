package com.revature.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.revature.accounts.Account;
import com.revature.bank.Bank;
import com.revature.services.AccountServices;
import com.revature.services.CustomerServices;
import com.revature.users.Customer;

public class EmployeeMenu {
	static boolean exit;
	static Scanner sc = new Scanner(System.in);
	static Scanner boo = new Scanner(System.in);
	
	public static void runEmployeeMenu() {
		while (!exit) {
			printEmployeeMenu();
			int option = userInput();
			optionSelect(option);
		}
	
		
	}

	private static void printEmployeeMenu() {
		System.out.println("=====================================");
		System.out.println("\nWelcome to the Employee menu\n");
		System.out.println("=====================================");
		System.out.println("Would you like to \n1 Access all customer information \n2 Review pending accounts \n3 Exit");
		
	}

	private static int userInput() {
		int option = 2000;
		int i = 0;
		do {
		try {
			option = Integer.parseInt(sc.nextLine());
		}
		catch(Exception e) {
			i++;
			if(i>4) {
				System.out.println("You have entered too many invalid attempts, the application will now close");
				System.exit(0);
			}
			if(i>2) {
				System.out.println("Press. An. Integer.");
			}
		}
		if(1>option||option>3) {
			System.out.println("Please enter one of the three options. 1 for Access all customer information, 2 for Review pending accounts, or 3 Exit");
		}
		
	}while ((1>option||option>3));
		return option;
	}

	
	
	private static void optionSelect(int option) {
		switch (option) {
		case 1: 
			//call all customer info like how it is in customer menu for one
			CustomerServices.listAllCustomers();
			AccountServices.listAllAccounts();
			System.out.println(Bank.getCustomers());
			
			// make option to exit
			break;
		case 2:
			CustomerServices.listAllCustomers();
			AccountServices.listAllAccounts();
			AccountServices.showPendingAccount();
			System.out.println("Enter the account number of the account you would you like to access or press 0 to exit");
			int option1 = Integer.parseInt(sc.nextLine());
			if(option1 == 0) {
				System.exit(0);
			}
			System.out.println("Approve or decline(press [t] to approve/press [f] to decline)");
			String c = sc.nextLine();
			boolean d = false;
			if(c.equals("t")) {
				d = true;
			}
			AccountServices.changePendingAccount(AccountServices.getAccount(option1),d);
			break;
		case 3:
			System.out.println("Thank you, have a nice day");
			System.exit(0);
		default:
			System.out.println("how?");
			break;
		}
		
	}
}
