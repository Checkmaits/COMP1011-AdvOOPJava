package brockmowry_sec001_ex03;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainAppController {
	
	// Factorial
	@FXML private TextField factorialField;
	@FXML private Button calculateFactorialButton;
	@FXML private TextArea leftOutputArea;
	
	// Car Loan
	@FXML private TextField loanField;
	@FXML private TextField interestField;
	@FXML private TextField durationField;
	@FXML private Button calculateLoanButton;
	@FXML private TextArea rightOutputArea;
	
	public void initialize() {
		calculateFactorialButton.setOnAction(event -> {
			if (factorialField.getText().isEmpty())
				return;
			
			var number = Integer.parseInt(factorialField.getText());
			var thread = new Thread(new FactorialThread(number, leftOutputArea));
			thread.start();
		});
		
		calculateLoanButton.setOnAction(event -> {
			if (loanField.getText().isEmpty())
				return;
			if (interestField.getText().isEmpty())
				return;
			if (durationField.getText().isEmpty())
				return;
			
			var loanAmount = Double.parseDouble(loanField.getText());
			var interest = Double.parseDouble(interestField.getText());
			var duration = Integer.parseInt(durationField.getText());
			
			rightOutputArea.setText(calculateCarLoanPayment(loanAmount, interest, duration) + "");
		});
	}
	
	double calculateCarLoanPayment(double loanAmount, double annualInterestRate, int loanDurationInYears) {
	    double monthlyInterestRate = (annualInterestRate / 100.0) / 12.0;
	    int numberOfPayments = loanDurationInYears * 12;
	    double monthlyPayment = loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

	    return monthlyPayment;
	}
	
}