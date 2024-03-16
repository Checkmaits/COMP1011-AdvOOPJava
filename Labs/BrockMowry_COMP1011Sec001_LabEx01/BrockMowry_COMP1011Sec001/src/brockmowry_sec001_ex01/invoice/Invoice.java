package brockmowry_sec001_ex01.invoice;

public class Invoice implements Payable {

	private final String partNumber;
	private final String partDescription;
	private final int quantity;
	private final double pricePerItem;

	// constructor
	public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
		if (quantity < 0)
			throw new IllegalArgumentException("Quantity must be >= 0");
		if (pricePerItem < 0.0)
			throw new IllegalArgumentException("Price per item must be >= 0");

		this.quantity = quantity;
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.pricePerItem = pricePerItem;
	}
	
	@Override
	public double getPaymentAmount() {
		return getQuantity() * getPricePerItem(); // calculate total cost
	}

	public String getPartNumber() {
		return partNumber;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Part No.: " + partNumber).append("\n");
		builder.append("Description: " + partDescription).append("\n");
		builder.append("Price (per item): " + pricePerItem);
		
		return builder.toString();
	}
	
}
