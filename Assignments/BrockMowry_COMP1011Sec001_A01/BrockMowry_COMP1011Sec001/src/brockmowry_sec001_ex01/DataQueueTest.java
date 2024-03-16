package brockmowry_sec001_ex01;

import java.util.Random;

public class DataQueueTest {

	public static void main(String[] args) {
		
		// queue of strings
		String[] strings = { "wztckvpwmk", "czcwlinmvu", "cwdcbswqhz", "jgrfsrpvkz", "bccgxbyrsa", "mzdakcpeml",
				"xiyjdzjlgi", "guymvdhuct" };
		var stringQueue = new DataQueue<String>();
		for (int i = 0; i < strings.length; i++) {
			var random = strings[new Random().nextInt(strings.length - 1)];
			stringQueue.enqueue(random);
		}
		
		stringQueue.printElements();
		System.out.println();
		
		stringQueue.dequeue();
		stringQueue.printElements();
		
		System.out.println(); // new line
		
		// queue of doubles
		var doubleQueue = new DataQueue<Double>();
		for (int i = 0; i < 10; i++) {
			var random = new Random().nextDouble(100);
			doubleQueue.enqueue(random);
		}
		
		doubleQueue.printElements();
		System.out.println();
		
		doubleQueue.dequeue();
		doubleQueue.printElements();
		
	}

}
