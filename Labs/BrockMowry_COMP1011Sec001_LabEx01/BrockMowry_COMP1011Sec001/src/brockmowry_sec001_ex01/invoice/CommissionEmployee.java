package brockmowry_sec001_ex01.invoice;

public class CommissionEmployee extends Employee {
	
	private double grossSales;
	private double commissionRate;

	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);

		if (commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be >= 0.0");

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	@Override
	public double getPaymentAmount() { return commissionRate * grossSales; }
	
	public double getGrossSales() { return grossSales; }
	
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be >= 0.0");

		this.grossSales = grossSales;
	}
	
	public double getCommissionRate() { return commissionRate; }

	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

		this.commissionRate = commissionRate;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(super.toString() + "\n");
		string.append("Gross Sales: " + grossSales).append("\n");
		string.append("Commision Rate: " + commissionRate);
		return string.toString();
	}
	
}
