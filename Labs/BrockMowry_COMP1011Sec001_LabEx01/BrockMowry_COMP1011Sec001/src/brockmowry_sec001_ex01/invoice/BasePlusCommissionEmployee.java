package brockmowry_sec001_ex01.invoice;

public class BasePlusCommissionEmployee extends CommissionEmployee {

	private double baseSalary;

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary + (baseSalary * 0.10); // (B)
	}
	
	@Override
	public double getPaymentAmount() { return baseSalary + super.getPaymentAmount(); }

	public double getBaseSalary() { return baseSalary; }
	
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(super.toString() + "\n");
		string.append("Base Salary: $" + baseSalary);
		
		return string.toString();
	}
	
}
