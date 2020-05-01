package com.revature.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.accounts.Account;
import com.revature.bank.Bank;
import com.revature.services.AccountServices;
import com.revature.services.BankServices;
import com.revature.services.CustomerServices;
import com.revature.users.Customer;

public class CustomerMenu {
	boolean exit;
	Scanner sc = new Scanner(System.in);
	Scanner dub = new Scanner(System.in);
	private String password;
	private String username;
	
	
	
	public CustomerMenu(String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	public void accountMenu(){
		Bank bank = new Bank();
		bank.pullAllBankInfo();
		while(!exit) {
		printAMenu();
		int option = userAInput();
		optionASelect(option);
		}
	}
	
	

	private void printAMenu() {
		System.out.println("======================================");
		System.out.println("\nWelcome to your account " + username);
		System.out.println("\n======================================");
		System.out.println("Type the number for which option you would like");
		System.out.println("1 Access accounts");
		System.out.println("2 Apply for a new account");
		System.out.println("3 Apply for a joint account");
		System.out.println("4 Exit");
	}
	
	private int userAInput() {
		int option = 2000;
		int i = 0;
		do {
		try {
			option = Integer.parseInt(sc.nextLine());
		}
		catch(Exception e) {
			i++;
			if(i>5) {
				System.out.println("Too many invalid attempts, you will be exited from the application");
				System.exit(0);
			}
			if(i>2) {
				System.out.println("Press an integer please");
			}
		}
		if(1>option||option>4) {
			System.out.println("Please enter one of the four options. 1 for Access accounts, 2 for Apply for a new account, 3 Apply for a joint account, or 4 Exit");
		}
		
	}while ((1>option||option>4));
		return option;
	}
	
	
	private void optionASelect(int option) {
		boolean a = false;
		int accType = 0;
		int i = 0;
		Account acc;
		Customer cust = CustomerServices.getCustomer(username);

		switch (option) {
		case 1: 
			System.out.println("\n\n\n\n\n\n\n\n====================================");
			System.out.println("\nWelcome to your account page\n");
			System.out.println("===================================");
			System.out.println(CustomerServices.getCustomerAccounts(CustomerServices.getCustomer(username)));
			System.out.println("\nType the number of the account you would like to access or press 0 to return to main menu");
			int choice = Integer.parseInt(sc.nextLine());
			System.out.println(AccountServices.getAccount(choice));
			if (choice == 0) {
				accountMenu();
			}
			acc = AccountServices.getAccount(choice);
			System.out.println("Choose which option you would like to choose \n1 Deposit \n2 Withdrawl \n3 Transfer\n4 Return to the main menu");
			accType = Integer.parseInt(sc.nextLine());
			
			switch (accType) {
			case 1: {
				int d = 0;
				while(!a) {
					System.out.println("\nHow much money would you like to deposit?");
					double deposit = dub.nextDouble();
					BankServices.deposit(acc, deposit);
					System.out.println("\nWould you like to make another deposit? 1 for yes 2 for no.");
					try {
						 d = Integer.parseInt(sc.nextLine());
					}catch(Exception e){
						i++;
						if(i>5) {
							System.out.println("Too many invalid attempts, you will be exited from the application");
							a = true;
							System.exit(0);
						}
						if(i>2) {
							System.out.println("Press an integer please");
						}
						if(d>2||d<1) {
							System.out.println("Please enter a valid option");
						}
						
					}
					if (d == 2) {
						System.out.println("\nReturning to main menu");
						a = true;
					}
				}
				break;
				}
			case 2:{
				int d = 0;
				while(!a) {
					System.out.println("\nHow much money would you like to withdraw?");
					double withdraw = dub.nextDouble();
					BankServices.withdraw(acc, withdraw);
					System.out.println("\nWould you like to make another withdrawl? 1 for yes 2 for no.");
					try {
						 d = Integer.parseInt(sc.nextLine());
					}catch(Exception e){
						i++;
						if(i>5) {
							System.out.println("Too many invalid attempts, you will be exited from the application");
							a = true;
							System.exit(0);
						}
						if(i>2) {
							System.out.println("Press an integer please");
						}
						if(d>2||d<1) {
							System.out.println("Please enter a valid option");
						}
						
					}
					if (d == 2) {
						System.out.println("Returning to main menu\n");
						a = true;
					}
				}
				break;
			}
			case 3:
				int d = 0;
				int dd = 0;
				while(!a) {
					System.out.println("What account would you like to transfer your funds to?");
					System.out.println(CustomerServices.getCustomerAccounts(CustomerServices.getCustomer(username)));
					dd = Integer.parseInt(sc.nextLine());
					System.out.println("How much money would you like to transfer?");
					double transfer = dub.nextDouble();
					BankServices.transfer(AccountServices.getAccount(choice), AccountServices.getAccount(dd), transfer);
					System.out.println("Would you like to make another transfer? 1 for yes 2 for no.");
					try {
						 d = Integer.parseInt(sc.nextLine());
					}catch(Exception e){
						i++;
						if(i>5) {
							System.out.println("Too many invalid attempts, you will be exited from the application");
							a = true;
							System.exit(0);
						}
						if(i>2) {
							System.out.println("Press an integer please");
						}
						if(d>2||d<1) {
							System.out.println("Please enter a valid option");
						}
						
					}
					if (d == 2) {
						System.out.println("Returning to main menu\n");
						a = true;
					}
				}
				break;
			case 4:
				System.out.println("Returning to main menu\n");
				break;
			default:
				System.out.println("Returning to main menu\n");
				break;
			}
			break;
		case 2:
			while (!a) {
			System.out.println("What type of account would you like to apply for?");
			System.out.println("1 Checkings");
			System.out.println("2 Savings");
			System.out.println("3 Return to main menu");
			acc = new Account();
			boolean b = false;
			ArrayList<Customer> arCust = new ArrayList<Customer>();
			arCust.add(cust);
			acc.setAccountHolder(arCust);
			
				try {
					accType = Integer.parseInt(sc.nextLine());
				}catch(NumberFormatException e){
					i++;
					if(i>5) {
						System.out.println("Too many invalid attempts, you will be exited from the application");
						System.exit(0);
					}
					if(i>2) {
						System.out.println("Press an integer please");
					}
				}
				if (accType == 1) {
					System.out.println("Please enter an inital deposit ammount to your checkings account");
					double deposit1 = dub.nextDouble();
					while(!b) {
					if (deposit1<100.00) {
						System.out.println("Need an initial deposit of $100 or more for a checkings account");
					}else {
						acc.setBalance(deposit1);
						AccountServices.addPendingAccount(deposit1 ,acc, "Checkings");
						System.out.println("Please wait for an employee to approve your account");
						System.out.println("Returning to main menu");
						accountMenu();
					}
				}}else if(accType == 2){
					System.out.println("Please enter an initial deposit amount to your savings account");
					double deposit1 = dub.nextDouble();
					while(!b) {
					if (deposit1<50) {
						System.out.println("Need an initial deposit of $50 or more");
					}else {
						acc.setBalance(deposit1);
						AccountServices.addPendingAccount(deposit1, acc, "Savings");
						System.out.println("Please wait for an employee to approve your account");
						System.out.println("Returning to main menu");
						accountMenu();
					}
				}}else {
					accountMenu();
				}
			}
			
			break;
		case 3: 
			System.out.println("Please enter the number of the account you would like to become a joint owner of");
			int d = Integer.parseInt(sc.nextLine());
			AccountServices.addToAccount(d,cust);
			break;
		case 4:
			System.out.println("Thank you have a nice day");
			System.exit(0);
		default:
			System.out.println("how?");
			System.exit(0);
			break;
		}
	}
}
