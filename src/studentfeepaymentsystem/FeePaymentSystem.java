package studentfeepaymentsystem;
import java.util.Scanner;
public class FeePaymentSystem {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		//while loop : keeps the application running until the user chooses to exit
		int choice =1;
		while(choice==1) {
			System.out.println("===============================");
			System.out.println("  STUDENT FEE PAYMENT SYSTEM   ");
			System.out.println("===============================");
			
			System.out.println("1.Enter student fee details");
			System.out.println("2.Exit");
			
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			
		if(choice==1) {
			System.out.println("How many students do you want to enter?");
			int number_of_students = scanner.nextInt();
			scanner.nextLine(); //clears left over enter key
			
			double total_fees = 0;
			double total_paid = 0;
			double total_balance = 0;
			
			
			//for loop : processes the fee information for each student
			
			
			for (int i=1; i <= number_of_students; i++) {
				System.out.println("\n--- Student" + i + "---");
				System.out.println("Enter student name: ");
				String student_name = scanner.nextLine();
				scanner.nextLine();
				
				System.out.println("Enter required fees: ");
				double required_fees = scanner.nextDouble();
				
				
				//do while loop : ensures the amount paid is not negative
				double amount_paid;
				 do {
					 System.out.println("Enter amount paid: ");
					 amount_paid= scanner.nextDouble();
					 
					 if(amount_paid < 0) {
						 System.out.println("Invalid amount. please enter 0 or more!!");
					 }
					 }while(amount_paid <0);
				 
				
				double balance = required_fees - amount_paid;
				double over_payment = 0;
				
				if (balance <0) {
					over_payment = -balance;
					balance = 0;
				}
				
				// ternary statement : determines the students payment status
				String status = amount_paid == 0? "No payment" :
					amount_paid >= required_fees ? "Fully Paid" :
						"Partially Paid";
				
				System.out.println("\nStudent: "+ student_name);
				System.out.println("Required fees: UGX "+ required_fees);
				System.out.println("Amount paid: UGX "+ amount_paid);
				System.out.println("Balance: UGX "+ balance);
				
				if (over_payment > 0) {
					System.out.println("Over payment: UGX " + over_payment );
				}
				System.out.println("Status: "+ status);
				
				
				// update totals for the summary
				total_fees += required_fees;
				total_paid += amount_paid;
				total_balance += balance;
				
				scanner.nextLine();
				
				
				
			   }
			
			
			// display summary after all students have been processed
			
			System.out.println("\n===============================");
			System.out.println("            summary              ");
			System.out.println("=================================");
			System.out.println("Total number of students:UGX "+ number_of_students);
			System.out.println("Total fees expected:UGX "+ total_fees);
			System.out.println("Total collected: UGX"+ total_paid);
			System.out.println("Total outstanding balance:UGX "+ total_balance);
			
			
			}
		}
		
	}
	

}
