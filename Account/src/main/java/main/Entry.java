package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import accounting.exceptions.DataFetchError;
import accounting.exceptions.DataWriteError;
import accounting.exceptions.InsufficientBalanceException;
import accounting.exceptions.UserNotFoundException;
import accounting.model.AccountBalance;

public class Entry {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Select Below");
		System.out.println("1 find all accounts of this user");
		System.out.println("2 Debit amount2");
		int option = Integer.valueOf(br.readLine());
		switch(option) {
		
		case 1 :
			try {
				List<AccountBalance > list = new AccountBalance().getBalances("918813884002");
				System.out.println("AccountID \t Balance");
				for(AccountBalance ab : list) {
					System.out.println(ab.getAccountID() + "\t" + ab.getBalance());
					
				}
				
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DataFetchError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2 :
			try {
				new AccountBalance().debit("918813884002", 5L, 1000000);
				System.out.println("Done");
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DataWriteError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
