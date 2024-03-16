package brockmowry_sec001_ex02;

import java.text.DecimalFormat;

public class Invoice {
	
	private final String partNo;
	private final String partDescription;
	private final int quantity;
	private final double pricePerItem;
	
	public Invoice(String partNo, String partDescription, int quantity, double pricePerItem) {
		this.partNo = partNo;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}
	
	public String getPartNo() {
		return partNo;
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
	
	public double getTotal() {
		var format = new DecimalFormat("#.##");
		return Double.parseDouble(format.format(pricePerItem * quantity));
	}
	
	@Override
    public String toString() {
        return String.format("%-10s %-10d %-20s %-10.2f %-10.2f", partNo, quantity, partDescription, pricePerItem, getTotal());
    }
	
}