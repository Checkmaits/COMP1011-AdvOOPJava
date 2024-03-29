package brockmowry_sec001_ex01;

public class FactorialCalculator extends Thread {
	
	private final int number;
	private long factorial;
	
	public FactorialCalculator(int number) { this.number = number; }
	
	@Override
	public void run() { factorial = calculateFactorial(number); }
	
	private long calculateFactorial(int n) {
		if (n == 0 || n == 1)
	        return 1;
	    
	    long result = 1;
	    for (int i = 2; i <= n; i++)
	        result *= i;
	    
	    return result;
	}
		
	public long getFactorial() { return factorial; }
	
}