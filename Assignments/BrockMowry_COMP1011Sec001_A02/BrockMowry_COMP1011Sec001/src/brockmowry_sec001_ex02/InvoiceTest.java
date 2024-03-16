package brockmowry_sec001_ex02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InvoiceTest {
	
	public static void main(String[] args) {
		var invoices = Arrays.asList(
				new Invoice("87", "Electric Sander", 7, 57.98),
				new Invoice("24", "Power Saw", 18, 99.99),
				new Invoice("7", "Sledge Hammer", 11, 21.50),
				new Invoice("77", "Hammer", 76, 11.99),
				new Invoice("39", "Lawn Mower", 3, 79.50),
				new Invoice("68", "Screwdriver", 106, 6.99),
				new Invoice("56", "Jigsaw", 21, 11.00)
		);
		
		printHeader();
		invoices.forEach(System.out::println);

		System.out.println("\nPART A:");
		partA(invoices);

		System.out.println("\nPART B:");
		partB(invoices);
		
		System.out.println("\nPART C:");
		partC(invoices);
		
		System.out.println("\nPART D:");
		partD(invoices);
		
		System.out.println("\nPART E:");
		partE(invoices);
		
		System.out.println("\nPART F:");
		partF(invoices);
	}
	
	private static void printHeader() {
		System.out.printf("%-10s %-10s %-20s %-10s %-10s\n", "Part No", "Quantity", "Description", "Price", "Total");
	}
	
	private static void partA(List<Invoice> invoices) {
		var sortedByDescription = invoices
				.stream()
				.sorted((invoice1, invoice2) -> invoice1.getPartDescription().compareTo(invoice2.getPartDescription()));
		printHeader();
		sortedByDescription.forEach(System.out::println);
	}
	
	private static void partB(List<Invoice> invoices) {
		var sortedByPrice = invoices
				.stream()
				.sorted(Comparator.comparingDouble(Invoice::getPricePerItem));
		printHeader();
		sortedByPrice.forEach(System.out::println);
	}
	
	private static void partC(List<Invoice> invoices) {
		var mapped = invoices
				.stream()
				.map(invoice -> String.format("%s - %d", invoice.getPartDescription(), invoice.getQuantity()))
				.sorted(Comparator.comparingInt(invoice -> {
					var quantity = invoice.split(" - ")[1];
					return Integer.parseInt(quantity);
				}));
		
		mapped.forEach(System.out::println);
	}
	
	private static void partD(List<Invoice> invoices) {
		var mapped = invoices
				.stream()
				.map(invoice -> String.format("%s - %f", invoice.getPartDescription(), invoice.getTotal()))
				.sorted(Comparator.comparingDouble(invoice -> {
					var quantity = invoice.split(" - ")[1];
					return Double.parseDouble(quantity);
				}));
		
		mapped.forEach(System.out::println);
	}
	
	
	private static void partE(List<Invoice> invoices) {
		var mapped = invoices
				.stream()
				.filter(invoice -> (invoice.getTotal() >= 200.00 && invoice.getTotal() <= 500.00))
				.map(invoice -> String.format("%s - %f", invoice.getPartDescription(), invoice.getTotal()))
				.sorted(Comparator.comparingDouble(invoice -> {
					var quantity = invoice.split(" - ")[1];
					return Double.parseDouble(quantity);
				}));
		
		mapped.forEach(System.out::println);
	}
	
	private static void partF(List<Invoice> invoices) {
		var selectedInvoice = invoices
				.stream()
				.filter(invoice -> invoice.getPartDescription().contains("saw"))
				.findAny().orElse(null);
		
		printHeader();
		System.out.println(selectedInvoice);
	}
		
}