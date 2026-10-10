import java.util.Scanner;

public class CollegeCanteenSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            double grandTotal = 0.0;
            
            for (int i = 0; i < n; i++) {
                String customerType = scanner.next();
                double amount = scanner.nextDouble();
                
                // Calculate final amount based on customer type and business rules
                double finalAmount = switch (customerType) {
                    case "STUDENT" -> amount - (amount * 0.10); // Students get a 10% discount
                    case "STAFF" -> amount - (amount * 0.05);   // Staff get a 5% discount
                    case "GUEST" -> amount + 10.0;              // Guests pay full amount plus ₹10 service charge[cite: 10]
                    default -> amount;
                };
                
                grandTotal += finalAmount;
                
                // Display each bill's final amount formatted to two decimal places[cite: 10]
                System.out.printf("%s: %.2f%n", customerType, finalAmount);
            }
            
            // Display the total amount collected formatted to two decimal places[cite: 10]
            System.out.printf("Total: %.2f%n", grandTotal);
        }
    }
}
