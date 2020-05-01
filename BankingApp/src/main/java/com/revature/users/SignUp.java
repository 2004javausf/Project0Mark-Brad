package com.revature.users;

import java.util.Scanner;

public class SignUp {
Scanner sc = new Scanner(System.in);
	public SignUp() {
		System.out.println("Welcome to the signup page");
		System.out.println("Please enter your first name");
		String fName = sc.nextLine();
		System.out.println("Please enter your last name");
		String lName = sc.nextLine();
		System.out.println("Would you like to open a checkings account or a savings account?");
		System.out.println("1 checkings\n 2 savings");
		
	}
	
}
