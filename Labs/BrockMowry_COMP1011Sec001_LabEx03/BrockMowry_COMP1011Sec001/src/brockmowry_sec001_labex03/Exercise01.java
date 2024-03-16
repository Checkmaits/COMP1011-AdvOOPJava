package brockmowry_sec001_labex03;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise01 {
	
	public static void main(String[] args) {
		var simpleArray = new SimpleArray(9);
		
		var writer1 = new ArrayWriter(simpleArray, 0);
		var writer2 = new ArrayWriter(simpleArray, 11);
		var writer3 = new ArrayWriter(simpleArray, 21);
		
		var executor = Executors.newCachedThreadPool();
		executor.execute(writer1);
		executor.execute(writer2);
		executor.execute(writer3);
		executor.shutdown();
		
		try {
			var hasCompleted = executor.awaitTermination(1, TimeUnit.MINUTES);
			if (hasCompleted) {
				System.out.printf("Contents of array: { %s }\n", simpleArray.contents());
				System.out.println("Writer 1 Numbers: " + writer1.addedNumbers());
				System.out.println("Writer 2 Numbers: " + writer2.addedNumbers());
				System.out.println("Writer 3 Numbers: " + writer3.addedNumbers());
				System.out.println("Sum of Writer 1: " + writer1.sum() );
				System.out.println("Sum of Writer 2: " + writer2.sum() );
				System.out.println("Sum of Writer 3: " + writer3.sum());
				
				return;
			}
			
			System.err.println("Timeout while waiting for tasks to finish...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}