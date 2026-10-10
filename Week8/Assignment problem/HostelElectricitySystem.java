import java.util.Scanner;

public class HostelElectricitySystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            double grandTotal = 0.0;
            
            for (int i = 0; i < n; i++) {
                String roomType = scanner.next();
                int units = scanner.nextInt();
                
                // Calculate bill based on room type and business rules using a switch expression
                double billAmount = switch (roomType) {
                    case "SINGLE" -> units * 8.0; // Single room: ₹8 per unit
                    case "SHARED" -> {
                        int occupants = scanner.nextInt();
                        yield (units * 6.0) / occupants; // Shared room: ₹6 per unit, divided equally by occupants
                    }
                    case "AC" -> (units * 10.0) + 200.0; // AC room: ₹10 per unit, plus a fixed charge of ₹200
                    default -> 0.0;
                };
                
                grandTotal += billAmount;
                
                // Display each room's bill amount formatted to two decimal places
                System.out.printf("%s: %.2f%n", roomType, billAmount);
            }
            
            // Display the total of all bills shown formatted to two decimal places[cite: 13]
            System.out.printf("Total: %.2f%n", grandTotal);
        }
    }
}
