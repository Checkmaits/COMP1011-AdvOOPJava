package brockmowry_sec001_ex03;

import java.math.BigInteger;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class FactorialThread implements Runnable {
	
	private final int number;
	private final TextArea outputArea;
	
	public FactorialThread(int number, TextArea outputArea) {
		this.number = number;
		this.outputArea = outputArea;
	}
	
	@Override
	public void run() {
		var result = calculate(number);
		Platform.runLater(() -> {
			outputArea.setText(result.toString());
		});
	}
	
	private BigInteger calculate(int number) throws IllegalArgumentException {
		if (number < 0)
			throw new IllegalArgumentException("Cannot calculate factorial for negative numbers");;
		
		var result = BigInteger.ONE;
		for (int i = 1; i <= number; i++)
            result = result.multiply(BigInteger.valueOf(i));

        return result;
	}
	
}