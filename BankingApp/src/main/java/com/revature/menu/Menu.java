package com.revature.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.revature.bank.Bank;
import com.revature.services.CustomerServices;
import com.revature.users.Customer;

public class Menu {
	static Map<String,String> users = new HashMap<String,String>();
	
	
	Scanner sc = new Scanner(System.in);
	public static Bank bank;
	boolean exit;
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.pullAllBankInfo();
		Bank.getCustomers();
		Menu m = new Menu();
		users.putAll(CustomerServices.getHashCustomer());
		m.runMenu();
	}
	
	
	
	public void runMenu() {
		users.putAll(CustomerServices.getHashCustomer());
		while (!exit) {
			System.out.println("\u001B[36m"+"=============================\n\nWelcome to M&B's Banc\n\n=============================\n"+"\u001B[0m");
			printMenu();
			int option = userInput();
			optionSelect(option);
		}
	}



	private void printMenu() {
		System.out.println("Do you have an account with us?");
		System.out.println("For yes press 1");
		System.out.println("For no press 2");
	}


	private int userInput() {
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
		if(1>option||option>2) {
			System.out.println("Please enter one of the two options. 1 for yes or 2 for no");
		}
		
	}while ((1>option||option>2));
		return option;
	}
			private void optionSelect(int option) {
					switch (option) {
					case 1: 
						logIn();
						break;
					case 2:
						while(!exit) {
							askMakeAccount();
							int option2 = userinput2();
							optionSelect2(option2);
						}
					default:
						System.out.println("how?");
						break;
		}
	
	}

			
			
			private void logIn() {
				int i1 = 0;
				while (!exit) {
				System.out.print("Please enter your username: ");
				String username = sc.nextLine();
				i1++;
				if (username.equals("Employee")) {
					System.out.print("Please enter your password: ");
					String password = sc.nextLine();
					if(password.equals("Employee")) {
							EmployeeMenu.runEmployeeMenu();
					}
				}else if (users.containsKey(username)) {
					System.out.println("Your username is: "+username);
				
	
					
					System.out.print("Please enter your password: ");
					String password = sc.nextLine();
					if ((users.get(username)).equals(password)) {
						CustomerMenu c = new CustomerMenu(username,password);
						c.accountMenu();
					}else {
					for(int i = 0;i<=3;i++) {
						if ((users.get(username)).equals(password)) {
							CustomerMenu c = new CustomerMenu(username,password);
							c.accountMenu();
						}
						System.out.println("The password you entered was incorrect. Try again.");
						password = sc.nextLine();
						if (i == 3) {
							System.out.println("The account is locked.");
							System.exit(0);
							break;
						}
					}
				}
				}else if (username.equals("Admin")) {
					System.out.print("Please enter your password: ");
					String password = sc.nextLine();
					if(password.equals("Admin")) {
							AdminMenu.runAdminMenu();
					}
				}
				else if(username.equals("exit")) {
					System.exit(0);
				}
				else {
					if (i1>3) {
						System.out.println("Too many invalid attempts.");
						System.exit(0);
					}
					System.out.println("You have not enetered a valid username, please try again, if you would like to exit type 'exit'");
				}
				
			}
			}

			
			
			
			
			
			


					private void askMakeAccount() {
							System.out.println("Would you like to have an account with us?");
							System.out.println("For yes press 1");
							System.out.println("For no press 2");

}
					private int userinput2() {
						int option2 = 2000;
						int i2 = 0;
						do {
						try {
							option2 = Integer.parseInt(sc.nextLine());
						}
						catch(Exception e) {
							i2++;
							if(i2>5) {
								System.out.println("Too many invalid attempts made, app will be exited now");
								System.exit(0);
							}
							if(i2>2) {
								System.out.println("You know the drill.");
							}
						}
						if(1>option2||option2>2) {
							System.out.println("Please enter one of the two options. 1 for yes or 2 for no");
						}}while ((1>option2||option2>2));
						return option2;
			}
					
					private void optionSelect2(int option2) {
						if (option2 == 2) {
						System.out.println("Thank you have a good day.");
						System.exit(0);
						}
						else {
							createAccount();
						}
							
			}



					private void createAccount() {
						int i = 0;
						boolean taken = false;
						String username = null;
						while(!taken) {
							System.out.print("Please enter your preferred username: ");
							username = sc.nextLine();
							//if the username is in our list make a statement saying it is a taken username
							if(users.containsKey(username)) {
								System.out.println("Sorry this username is taken");
							}else {
							System.out.println("Your chosen username is: "+username);
							taken = true;
							}
						}
							while(!exit) {
								i++;
								
							System.out.println("Please enter your password: ");
							String password = sc.nextLine();
							
							System.out.println("Please re-enter your password: ");
							String test = sc.nextLine();
							if(test.equals(password)) {
								System.out.println("Passwords match.");
								CustomerServices.addCustomer(username, test);
								CustomerMenu c = new CustomerMenu(username,test);
								c.accountMenu();
							}
							else {
								if (i>3) {
									System.out.println("Your passwords still do not match, program ending.");
									System.exit(0);
								}
								System.out.println("Passwords do not match. Please try again.");
								
							}
							}
					}
					
					
					
					
					
					

					
	}
