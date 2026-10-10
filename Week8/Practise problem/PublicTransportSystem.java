import java.util.Scanner;

public class PublicTransportSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            double grandTotal = 0.0;
            
            for (int i = 0; i < n; i++) {
                String transportType = scanner.next();
                double distance = scanner.nextDouble();
                
                // Converted to a rule switch to resolve the hint
                double fare = switch (transportType) {
                    case "BUS" -> {
                        double f = 2.0 + (distance * 0.10); // Base $2, plus $0.10 per km[cite: 8]
                        yield f > 10.0 ? 10.0 : f;          // Max fare $10[cite: 8]
                    }
                    case "TRAIN" -> 3.0 + (distance * 0.15); // Base $3, plus $0.15 per km[cite: 8]
                    case "METRO" -> {
                        double peakHourFactor = scanner.nextDouble();
                        yield (1.50 + (distance * 0.20)) * peakHourFactor; // Base $1.50, plus $0.20/km, multiplied by PeakHourFactor[cite: 8]
                    }
                    default -> 0.0;
                };
                
                grandTotal += fare;
                
                // Display each journey's calculated fare formatted to two decimal places[cite: 8]
                System.out.printf("%s: %.2f%n", transportType, fare);
            }
            
            // Display the grand total formatted to two decimal places[cite: 8]
            System.out.printf("Total: %.2f%n", grandTotal);
        }
    }
}
