package brockmowry_sec001_ex01;

public class Transaction implements Runnable {
	
	private final Account account;
	private final double amount;
	private final Type type;
	
	public Transaction(Account account, double amount, Type type) {
		this.account = account;
		this.amount = amount;
		this.type = type;
	}
	
	@Override
	public void run() {
		if (type == Type.DEPOSIT) {
			account.deposit(amount);
			System.out.printf("+ $%f (%f)\n", amount, account.getAccountBalance());
			return;
		}
		
		try {
			account.withdrawal(amount);
			System.out.printf("- $%f (%f)\n", amount, account.getAccountBalance());
		} catch (InsufficientFundsException e) {
			System.err.println("Transaction error: " + e.getMessage());
		}
	}
	
	public enum Type { DEPOSIT, WITHDRAWAL }
	
} 