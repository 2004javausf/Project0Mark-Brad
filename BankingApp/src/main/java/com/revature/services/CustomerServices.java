package com.revature.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import com.revature.accounts.Account;
import com.revature.bank.Bank;
import com.revature.users.Customer;

public class CustomerServices {
//------------------------------------------------------------------
// CustomerServices
//			.getCustomer()
//			.getCustomerAccounts()
//			.addCustomer()
//			.listAllCustomers()
//			.removeCustomer()
//			.editCustomerInfo()
	
	public static Customer getCustomer(String username) {
		Iterator<Customer> itr = Bank.getCustomers().iterator();
		while(itr.hasNext()) {
			Customer currCustomer = itr.next();
			if(currCustomer.getUsername().equals(username)) {
				return currCustomer;
			}
		}
		return null;
	}
	
	public static Map<String,String> getHashCustomer() {
		Iterator<Customer> itr = Bank.getCustomers().iterator();
		Map<String,String> users = new HashMap<>();
		while(itr.hasNext()) {
			Customer currCustomer = itr.next();
			users.put(currCustomer.getUsername(), currCustomer.getPassword());
		}
		return users;
	}
	public static ArrayList<Account> getCustomerAccounts(Customer customer) {
		Iterator<Account> itr = Bank.getAccounts().iterator();
		ArrayList<Account> customerAccounts = new ArrayList<>();
		while(itr.hasNext()) {
			Account accountItr = itr.next();
			Iterator<Customer> customerItr = accountItr.getAccountHolder().iterator();
			while(customerItr.hasNext()) {
				if(customerItr.next().getUsername().equals(customer.getUsername())) {
					customerAccounts.add(accountItr);
				}
			}
		}
		return customerAccounts;
	}
	
	public static void addCustomer(String username, String password) {
		Customer newCustomer = new Customer(username,password);
		Bank.getCustomers().add(newCustomer);
		Bank.pushAllBankInfo();
	}
	public static void addCustomer(Customer customer) {
		Bank.getCustomers().add(customer);
		Bank.pushAllBankInfo();
	}
	public static void listAllCustomers() {
		Iterator<Customer> itr = Bank.getCustomers().iterator();
		System.out.println("All Customers:");
		while(itr.hasNext()) {
			Customer currCustomer = itr.next();
			System.out.println("\t"+currCustomer.getUsername());
		}
		System.out.println();
	}
	public static void removeCustomer(Customer customer) {
		ListIterator<Customer> itr = Bank.getCustomers().listIterator();
		boolean edited=false;
		try {
			while(itr.hasNext()) {
				Customer currCustomer = itr.next();
				if(currCustomer.getUsername().equals(customer.getUsername())) {
					System.out.println("Removed customer: "+customer.getUsername()+"\n");
					itr.remove();
					edited = true;
				}
			}
		} catch (Exception e) {
			System.out.println("could not remove customer\n");
		}
		if(edited) {
			Bank.pushAllBankInfo();
		} else {
			System.out.println("could not remove customer\n");
		}
	}
	public static void removeCustomer(String username) {
		ListIterator<Customer> itr = Bank.getCustomers().listIterator();
		boolean edited=false;
		try {
			while(itr.hasNext()) {
				Customer currCustomer = itr.next();
				if(currCustomer.getUsername().equals(username)) {
					System.out.println("Removed customer: "+username+"\n");
					itr.remove();
					edited = true;
				}
			}
		} catch (Exception e) {
			System.out.println("could not remove customer\n");
		}
		if(edited) {
			Bank.pushAllBankInfo();
		} else {
			System.out.println("could not remove customer\n");
		}
	}
	public static void editCustomerInfo(Customer customer, String property, String newValue) {
		ListIterator<Customer> itr = Bank.getCustomers().listIterator();
		String oldUsername = customer.getUsername();
		boolean edited=false; 
		try {
			while(itr.hasNext()) {
				Customer currCustomer = itr.next();
				if(currCustomer.getUsername().equals(customer.getUsername())) {
					switch(property) {
					case "username":
						currCustomer.setUsername(newValue);
						edited = true;
						break;
					case "password":
						currCustomer.setPassword(newValue);
						edited = true;
						break;
					default:
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Could not edit the customer");
		}
		
		if(edited) {
			System.out.println(oldUsername+"'s "+property+ " has been updated to " + newValue+"\n");
			Bank.pushAllBankInfo();
		}else {
			System.out.println("Could not edit the customer");
		}
		
	}
	
}