package brockmowry_sec001_ex01;

public abstract class Employee {
	
	private final String firstName;
	private final String lastName;
	private final String sinNumber;

	public Employee(String firstName, String lastName, String sinNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sinNumber = sinNumber;
	}
	
	public abstract double earnings();

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getSinNumber() { return sinNumber; }

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(String.format("%s, %s (SIN: %s)", lastName, firstName, sinNumber));
		
		return string.toString();
	}
	
}
