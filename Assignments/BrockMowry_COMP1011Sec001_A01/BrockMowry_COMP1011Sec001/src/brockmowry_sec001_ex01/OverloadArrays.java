package brockmowry_sec001_ex01;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OverloadArrays {
	
	private static <T> void printArray(T[] inputArray) {
		System.out.println("Type: " + inputArray.getClass().getSimpleName());
		System.out.printf("Elements: { %s }\n", Arrays.stream(inputArray)
				.map(String::valueOf).collect(Collectors.joining(", ")));
	}
	
	private static <T> void printArray(T[] inputArray, int startIndex) {
		if (startIndex < 0 || startIndex >= inputArray.length)
			throw new IllegalArgumentException("Start index out of bounds");
		
		T[] newArray = Arrays.copyOfRange(inputArray, startIndex, inputArray.length);
		printArray(newArray);
	}
	
	private static <T> void printArray(T[] inputArray, int startIndex, int endIndex) {
		if (startIndex < 0 || startIndex > inputArray.length - 1)
			throw new IllegalArgumentException("Start index out of bounds");
		if (endIndex <= startIndex || endIndex > inputArray.length)
			throw new IllegalArgumentException("End index out of bounds");
		
		T[] newArray = Arrays.copyOfRange(inputArray, startIndex, endIndex);
		printArray(newArray);
	}
	
	public static void main(String[] args) {
		Double[] grades = { 56.7, 89.23, 45.56, 88.40, 90.56 };
		printArray(grades);
		
		String[] products = { "iPhone", "Samsung", "Pixel", "Nokia" };
		printArray(products, 1);
		
		Character[] status = { 'y', 'n', 'i', 'd', 'e' };
		printArray(status, 1, 5);
	}

}