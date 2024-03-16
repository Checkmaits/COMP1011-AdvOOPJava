package brockmowry_sec001_ex01.invoice;

public abstract class Employee implements Payable {
	
	private final String firstName;
	private final String lastName;
	private final String sinNumber;

	public Employee(String firstName, String lastName, String sinNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sinNumber = sinNumber;
	}
	
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
