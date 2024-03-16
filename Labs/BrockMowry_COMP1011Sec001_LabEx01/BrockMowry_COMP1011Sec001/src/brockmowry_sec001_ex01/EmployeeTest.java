package brockmowry_sec001_ex01;

public class EmployeeTest {
	
	public static void main(String[] args) {
		Employee[] employees = { 
				// Base + Commission
				new BasePlusCommissionEmployee("John", "Smith", "650 747 470", 53.4, 0.8, 43.56),
				
				// Commission
				new CommissionEmployee("Jane", "Doe", "650 747 471", 109.34, 0.9),
				
				// Hourly
				new HourlyEmployee("Brock", "Mowry", "650 747 472", 109.34, 52),
				
				// PieceWorker
				new PieceWorker("Joe", "Biden", "650 747 473", 10000.98, 20),
				
				// Salaried Employee
				new SalariedEmployee("Donald", "Trump", "650 747 474", 4567.89)
		};
		
		for (int i = 0; i < employees.length; i++) {
			Employee employee = employees[i];
			System.out.println(employee.toString());
			System.out.println("Type: " + employee.getClass().getSimpleName());
			System.out.println(String.format("Total Earnings: $%.2f", employee.earnings()));
			
			// Separator except for last one
			if (i < employees.length - 1)
				System.out.println("-----------");
		}
	}

}
