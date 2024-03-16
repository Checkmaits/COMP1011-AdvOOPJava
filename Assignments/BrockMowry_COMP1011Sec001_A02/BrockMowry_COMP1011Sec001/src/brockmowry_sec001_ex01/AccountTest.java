package brockmowry_sec001_ex01;

import java.util.Arrays;
import java.util.concurrent.Executors;

import brockmowry_sec001_ex01.Transaction.Type;

public class AccountTest {
	
	public static void main(String[] args) {
		var account = new Account(100.00);
		var transactions = Arrays.asList(
				new Transaction(account, 50.00, Type.WITHDRAWAL),
				new Transaction(account, 100.00, Type.DEPOSIT),
				new Transaction(account, 650.00, Type.DEPOSIT),
				new Transaction(account, 400.50, Type.WITHDRAWAL)
		);
		
		var executor = Executors.newFixedThreadPool(transactions.size());
		transactions.forEach(executor::execute);
		
		executor.shutdown();
		while (!executor.isTerminated()) {}
		
		System.out.println(); // empty line
		account.printSummary();
	}
	
}