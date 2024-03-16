package brockmowry_sec001_ex01.invoice;

public class PayableInterfaceTest {

	public static void main(String[] args) {
		Payable[] costs = {
				new Invoice("1234", "2017 MacBook Air", 1, 599.99),
				new Invoice("1356", "2023 Honda Civic", 1, 24999.99),
				new HourlyEmployee("Brock", "Mowry", "123 456 789", 67.37, 60),
				new SalariedEmployee("Joe", "Biden", "123 567 373", 40000.99),
				new CommissionEmployee("Donald", "Duck", "123 567 374", 100000, 0.39),
				new BasePlusCommissionEmployee("Bugs", "Bunny", "123 567 376", 100000, 0.39, 40000)
		};
		
		System.out.println("Company weekly costs...:\n");
		for (int i = 0; i < costs.length; i++) {
			System.out.println(costs[i].toString());
			System.out.println("Total: $" + costs[i].getPaymentAmount());
			System.out.println("Type: " + costs[i].getClass().getSimpleName());
			
			if (i < costs.length - 1)
				System.out.println("-----------");
		}
	}
	
}
