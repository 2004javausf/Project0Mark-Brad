package com.revature.menu;

import java.util.Scanner;

import com.revature.accounts.Account;
import com.revature.bank.Bank;
import com.revature.services.AccountServices;
import com.revature.services.BankServices;
import com.revature.services.CustomerServices;
import com.revature.users.Customer;

public class AdminMenu {

	static boolean exit;
	static Scanner sc = new Scanner(System.in);
	static Scanner dub = new Scanner(System.in);
	
	public static void runAdminMenu() {
		while (!exit) {
			printAdminMenu();
			int option = userInput();
			optionSelect(option);
		}
	
		
	}

	private static void printAdminMenu() {
		System.out.println("=====================================");
		System.out.println("\nWelcome to the Admin menu\n");
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
			System.out.println("Please enter one of the three options. 1 for Access all customer information, 2 for Review pending accounts, or 3 for Exit");
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
			System.out.println("Would you like to 1 Edit an account or 2 Return to admin menu");
			int i = 0;
			int choice  = 200;
			try {
				choice = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e) {
				i++;
				if(i>4) {
					System.out.println("You have entered too many invalid attempts, the application will now close");
					System.exit(0);
				}
				if(i>2) {
					System.out.println("Press. An. Integer.");
				}
			}
			if(1>option||option>2) {
				System.out.println("Please enter one of the two options. 1 for edit an account or 2 return to main menu");
			}
			switch(choice) {
			case 1:
				// all the stuff we can do in account and add delete method
//				Customer cust = CustomerServices.getCustomer(username);
				
				System.out.println("\nWhat account would you like to access");
				int accountNumber = Integer.parseInt(sc.nextLine());
				Account acc = AccountServices.getAccount(accountNumber);
				System.out.println("\nWould you like to \n1 deposit \n2 withdraw \n3 transfer \n4 remove the account");
				int option2 = Integer.parseInt(sc.nextLine());
				switch (option2) {
				case 1:
					boolean a = false;
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
							a = true;
						}
					}
					break;
				case 2:
					int d1 = 0;
					boolean a1 = false;
					while(!a1) {
						System.out.println("\nHow much money would you like to withdraw?");
						double withdraw = dub.nextDouble();
						BankServices.withdraw(acc, withdraw);
						System.out.println("\nWould you like to make another withdrawl? 1 for yes 2 for no.");
						try {
							 d1 = Integer.parseInt(sc.nextLine());
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
							if(d1>2||d1<1) {
								System.out.println("Please enter a valid option");
							}
							
						}
						if (d1 == 2) {
							a = true;
						}
					}
					break;
				case 3:
					boolean a2 = false;
					int d2 = 0;
					int dd = 0;
					while(!a2) {
						System.out.println("\nWhat account would you like to transfer your funds to?");
						System.out.println(acc);
						dd = Integer.parseInt(sc.nextLine());
						System.out.println("\nHow much money would you like to transfer?");
						double transfer = dub.nextDouble();
						BankServices.transfer(AccountServices.getAccount(choice), AccountServices.getAccount(dd), transfer);
						System.out.println("\nWould you like to make another transfer? 1 for yes 2 for no.");
						try {
							 d2 = Integer.parseInt(sc.nextLine());
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
							if(d2>2||d2<1) {
								System.out.println("Please enter a valid option");
							}
							
						}
						if (d2 == 2) {
							a = true;
						}
					}
					break;
				case 4:
					AccountServices.removeAccount(accountNumber);
					break;
				default:
					break;
				}
				break;
			case 2:
				runAdminMenu();
				break;
			default:
				runAdminMenu();
			}
			break;
		case 2:
			CustomerServices.listAllCustomers();
			AccountServices.listAllAccounts();
			AccountServices.showPendingAccount();
			System.out.println("Enter the account number of the account you would you like to access or press 0 to return to main menu");
			int option1 = Integer.parseInt(sc.nextLine());
			if(option1 == 0) {
				runAdminMenu();
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
