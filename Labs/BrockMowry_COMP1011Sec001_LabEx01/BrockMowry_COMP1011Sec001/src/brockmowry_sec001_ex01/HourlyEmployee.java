package brockmowry_sec001_ex01;

public class HourlyEmployee extends Employee {
	
	private double wage;
	private double hours;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);

		if (wage < 0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		if ((hours < 0.0) || (hours > 168.0))
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

		this.wage = wage + 2.0; // (D)
		this.hours = hours;
	}
	
	@Override
	public double earnings() {
		return hours <= 48 ? wage * hours : (40 * hours) + ((hours - 40) * (wage * 1.5));
	}

	public double getWage() { return wage; }
	
	public void setWage(double wage) {
		if (wage < 0.0)
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");

		this.wage = wage;
	}
	
	public double getHours() { return hours; }

	public void setHours(double hours) {
		if ((hours < 0.0) || (hours > 168.0))
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

		this.hours = hours;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(super.toString() + "\n");
		string.append("Hourly Rate: " + wage).append("\n");
		string.append("Hours worked: " + hours);
		
		return string.toString();
	}
	
}
