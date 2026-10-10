import java.util.Scanner;

public class DeliveryServiceSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            double grandTotal = 0.0;
            
            for (int i = 0; i < n; i++) {
                String deliveryType = scanner.next();
                double weight = scanner.nextDouble();
                double distance = scanner.nextDouble();
                
                // Converted to a rule switch to resolve the hint
                double fee = switch (deliveryType) {
                    case "STANDARD" -> 5.0 + (weight * 0.50) + (distance * 0.10); // Base $5 + $0.50/kg + $0.10/km[cite: 5]
                    case "EXPRESS" -> 15.0 + (weight * 1.00) + (distance * 0.20); // Base $15 + $1.00/kg + $0.20/km[cite: 5]
                    case "INTERNATIONAL" -> {
                        double customsFee = scanner.nextDouble();
                        yield 25.0 + (weight * 2.00) + (distance * 0.50) + customsFee; // Base $25 + $2/kg + $0.50/km + Customs[cite: 5]
                    }
                    default -> 0.0;
                };
                
                grandTotal += fee;
                
                // Display each delivery's calculated fee formatted to two decimal places[cite: 5]
                System.out.printf("%s: %.2f%n", deliveryType, fee);
            }
            
            // Display the grand total formatted to two decimal places[cite: 5]
            System.out.printf("Total: %.2f%n", grandTotal);
        }
    }
}