package brockmowry_sec001_ex01;

public class InsufficientFundsException extends Exception {
	
	public InsufficientFundsException() {
		super("You do not have enough funds to complete this transaction");
	}
	
}