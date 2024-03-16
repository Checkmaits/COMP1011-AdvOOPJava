package brockmowry_sec001_labex03;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class SimpleArray {
	
	private final int[] array;
	private int writeIndex = 0;
	
	public SimpleArray(int size) {
		this.array = new int[size];
	}
	
	public synchronized void add(int value) {
		var position = writeIndex;
		
		// sleep the thread
		try { Thread.sleep(new Random().nextInt(500)); }
		catch (Exception e) { e.printStackTrace(); }
		
		array[position] = value;
		writeIndex++;
	}
	
	public String contents() {
		return Arrays.stream(array)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", "));
	}
	
}