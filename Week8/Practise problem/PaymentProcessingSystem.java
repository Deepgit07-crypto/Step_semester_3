import java.util.Scanner;

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        // 1. Fixes the resource leak by using try-with-resources
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            double grandTotal = 0.0;
            
            for (int i = 0; i < n; i++) {
                String paymentType = scanner.next();
                double amount = scanner.nextDouble();
                double adjustedAmount;
                
                // 2. Converted if-else to a switch statement to clear the hint
                switch (paymentType) {
                    case "CARD":
                        adjustedAmount = amount + (amount * 0.02); // 2% fee
                        break;
                    case "WALLET":
                        adjustedAmount = amount + (amount * 0.01); // 1% fee
                        break;
                    case "BANKTRANSFER":
                    default:
                        adjustedAmount = amount; // No fee
                        break;
                }
                
                grandTotal += adjustedAmount;
                System.out.printf("%s: %.2f%n", paymentType, adjustedAmount);
            }
            
            System.out.printf("Total: %.2f%n", grandTotal);
        }
    }
}