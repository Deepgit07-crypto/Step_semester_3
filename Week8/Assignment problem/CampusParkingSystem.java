import java.util.Scanner;

public class CampusParkingSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            double grandTotal = 0.0;
            
            for (int i = 0; i < n; i++) {
                String vehicleType = scanner.next();
                int hours = scanner.nextInt();
                
                // Declared and assigned directly using a switch expression to fix the warning
                double charge = switch (vehicleType) {
                    case "BIKE" -> hours * 10.0; // Bike: ₹10 per hour[cite: 11]
                    case "CAR" -> hours == 1 ? 30.0 : 30.0 + ((hours - 1) * 20.0); // Car: ₹30 for first hour, plus ₹20 for each additional hour[cite: 11]
                    case "TRUCK" -> Math.max(hours * 50.0, 100.0); // Truck: ₹50 per hour, with a minimum charge of ₹100[cite: 11]
                    default -> 0.0;
                };
                
                grandTotal += charge;
                
                // Display each vehicle's charge formatted to two decimal places[cite: 11]
                System.out.printf("%s: %.2f%n", vehicleType, charge);
            }
            
            // Display the total charge collected formatted to two decimal places[cite: 11]
            System.out.printf("Total: %.2f%n", grandTotal);
        }
    }
}
