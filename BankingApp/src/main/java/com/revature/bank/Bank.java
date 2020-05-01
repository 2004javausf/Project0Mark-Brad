package com.revature.bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.revature.accounts.Account;
import com.revature.users.Customer;

public class Bank {
	private static  ArrayList<Customer> customers = new ArrayList<>();
	private static  ArrayList<Account> accounts = new ArrayList<>();
	private static  int accountNumCount = 1000;
	private  final static String customerFile="Customers.txt";
	private  final static String accountFile="Accounts.txt";
	private  final static String accountNumberFile="AccountNumberTracker.txt";
	
	public Bank(){
	}
//Getters and setters ----------------------------------------------------------------
	public void pullAllBankInfo() {
		this.customers = pullCustomerList();
		this.accounts = pullAccountList();
		this.accountNumCount = pullAccountNumber();
	}
	public static void pushAllBankInfo() {
		pushAccountFile(accounts);
		pushAccountNumber(accountNumCount);
		pushCustomerFile(customers);
	}
	public static void incAccountNumCount() {
		Bank.accountNumCount++;
		pushAccountNumber(Bank.getAccountNumCount());
	}
	public static ArrayList<Customer> getCustomers() {
		return customers;
	}
	public static ArrayList<Account> getAccounts() {
		return accounts;
	}
	public static int getAccountNumCount() {
		return accountNumCount;
	}
	
//Bank service methods  ----------------------------------------------------------------
//	Bank
//		.pushAccountNumber
//		.pushCustomerFile
//		.pushAccountFile
//		.pullAccountNumber
//		.pullCustomerFile
//		.pullAccontFile
	
	
	//TODO: resetBankValues()
	private static void pushAccountNumber(Integer contents) {
		String numToString = contents.toString();
		OutputStream os= null;
		File file = new File(accountNumberFile);
		try {
			os= new FileOutputStream(file,false);
			os.write(numToString.getBytes());			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(os!=null) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void pushCustomerFile(Object modifiedList) {
		try {
			FileOutputStream fileOut = new FileOutputStream(customerFile);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(modifiedList);
			fileOut.close();
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void pushAccountFile(Object modifiedList) {
		try {
			FileOutputStream fileOut = new FileOutputStream(accountFile);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(modifiedList);
			fileOut.close();
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int pullAccountNumber() {
		InputStream is= null;
		File file= new File(accountNumberFile);
		StringBuilder s= new StringBuilder();
		
		try {
			is= new FileInputStream(file);
			int b=0;
			while((b=is.read())!=-1) {
				char c=(char)b;
				s.append(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(is!=null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	return Integer.parseInt(s.toString());
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Customer> pullCustomerList(){
		ArrayList<Customer> updatedCustomerList = new ArrayList<>();
		try {
			FileInputStream fileIn = new FileInputStream(customerFile);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			updatedCustomerList = (ArrayList<Customer>) objectIn.readObject();
			fileIn.close();
			objectIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return updatedCustomerList;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Account> pullAccountList(){
		ArrayList<Account> updatedAccountList = new ArrayList<>();
		try {
			FileInputStream fileIn = new FileInputStream(accountFile);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			updatedAccountList = (ArrayList<Account>) objectIn.readObject();
			fileIn.close();
			objectIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return updatedAccountList;
	}

}