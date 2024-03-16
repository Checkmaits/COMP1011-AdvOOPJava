package brockmowry_sec001_ex01;

import java.text.DecimalFormat;

public class Account {
	
	private final double initialBalance;
	private double accountBalance;
	private int transactionsPerformed = 0;
	private final DecimalFormat format = new DecimalFormat("#.##");
	
	public Account(double accountBalance) {
		this.initialBalance = accountBalance;
		this.accountBalance = accountBalance; 
	}
	
	public synchronized void deposit(double amount) {
		if (amount < 1)
			return;
		
		accountBalance = Double.parseDouble(format.format(accountBalance + amount));
		transactionsPerformed++;
	}
	
	public synchronized void withdrawal(double amount) throws InsufficientFundsException {
		if (amount > accountBalance)
			throw new InsufficientFundsException();
		
		accountBalance = Double.parseDouble(format.format(accountBalance - amount));
		transactionsPerformed++;
	}
	
	public void printSummary() {
		System.out.println("Initial balance: " + initialBalance);
		System.out.println("Transactions performed: " + transactionsPerformed);
		System.out.println("Final balance: " + accountBalance);
	}
	
	public double getAccountBalance() {
		return Double.parseDouble(format.format(accountBalance));
	}
	
}