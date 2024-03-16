package brockmowry_sec001_ex01;

import java.util.ArrayList;
import java.util.List;

public class DataQueue<T> {

	// no constructor needed.
	// can do this in-line
	private final List<T> queue = new ArrayList<>();
	
	public void enqueue(T element) { queue.add(element); }
	
	public void dequeue() {
		if (queue.isEmpty())
			throw new IllegalStateException("Queue is empty. Cannot remove something that doesn't exist.");
		
		queue.remove(0);
	}
	
	public void printElements() {
		if (queue.isEmpty()) {
			System.out.println("Queue is empty...");
			
			return;
		}
		
		for (int i = 0; i < queue.size(); i++)
			System.out.printf("%d: %s\n", i, queue.get(i).toString());
	}
	
}
