package com.test;


	
	

	import static org.junit.jupiter.api.Assertions.fail;

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
	import java.util.Arrays;

	import org.junit.jupiter.api.Test;

	import com.revature.accounts.Account;
	import com.revature.bank.Bank;
	import com.test.SampleAccount;
	import com.test.SampleCustomer;
	import com.revature.users.Customer;

	public class BankTests {
		Customer customer = new SampleCustomer().sample1();
		Account account = new SampleAccount().sample1();
		ArrayList<Account> accArray = (ArrayList<Account>) Arrays.asList(account);
//		Bank bank = new Bank(account.getAccountHolder(),accArray);
		static String testCustomerFile="TestCustomers.txt";
		static String testAccountFile="TestAccounts.txt";
		static String testAccountNumberFile="TestNumberTracker.txt";
		
		
		
		@Test
		void testPullAllBankInfo() {
			fail("Not yet implemented");
		}

		@Test
		void testPushAllBankInfo() {
			fail("Not yet implemented");
		}

		@Test
		void testIncAccountNumCount() {
			fail("Not yet implemented");
		}

		@Test
		void testPullAccountNumber() {
			fail("Not yet implemented");
		}

		@Test
		void testPullCustomerList() {
			fail("Not yet implemented");
		}

		@Test
		void testPullAccountList() {
			fail("Not yet implemented");
		}
		
		private static void pushAccountNumber(Integer contents) {
			String numToString = contents.toString();
			OutputStream os= null;
			File file = new File(testAccountNumberFile);
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
				FileOutputStream fileOut = new FileOutputStream(testCustomerFile);
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
				FileOutputStream fileOut = new FileOutputStream(testAccountFile);
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
			File file= new File(testAccountNumberFile);
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
				FileInputStream fileIn = new FileInputStream(testCustomerFile);
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
				FileInputStream fileIn = new FileInputStream(testAccountFile);
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
