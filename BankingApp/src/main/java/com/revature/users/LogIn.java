package com.revature.users;

import java.util.ArrayList;
import java.util.List;

import com.revature.menu.Menu;

public class LogIn {
	public static List<Customer> Customers = new ArrayList<Customer>();
	
	public static Customer logIn(String username) {
		for(int i = 0; i<Customers.size();i++) {
			String t = Customers.get(i).getUsername();
			if (username.equalsIgnoreCase(t)) {
				System.out.println("warrior found");
				return Customers.get(i);
			}	
		}
		return null;
	}
}
