package brockmowry_sec001_ex01;

public class PieceWorker extends Employee {
	
	private final double wage;
	private int pieces;
	
	public PieceWorker(
			String firstName, 
			String lastName, 
			String socialSecurityNumber,
			double wage,
			int pieces) {
		super(firstName, lastName, socialSecurityNumber);
		this.wage = wage;
		this.pieces = pieces;
	}

	@Override
	public double earnings() { return wage * pieces; }
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(super.toString() + "\n");
		string.append("Pieces made: " + pieces).append("\n");
		string.append("Wage per piece: $" + wage);
		
		return string.toString();
	}

}
