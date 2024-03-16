package brockmowry_sec001_ex01.invoice;

public class SalariedEmployee extends Employee {
	
   private double weeklySalary;

   public SalariedEmployee(String firstName, String lastName, 
      String socialSecurityNumber, double weeklySalary) {
      super(firstName, lastName, socialSecurityNumber); 

      if (weeklySalary < 0.0)
         throw new IllegalArgumentException("Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   }
   
   @Override                                                           
   public double getPaymentAmount() { return weeklySalary; }
   
   public double getWeeklySalary() { return weeklySalary; }          
   
   public void setWeeklySalary(double weeklySalary) {
      if (weeklySalary < 0.0)
         throw new IllegalArgumentException("Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   }
   
   @Override                                                   
   public String toString() {                                  
      StringBuilder builder = new StringBuilder(super.toString() + "\n");
      builder.append("Weekly salary: $" + weeklySalary);
      
      return builder.toString();
   }                                                           
} 


