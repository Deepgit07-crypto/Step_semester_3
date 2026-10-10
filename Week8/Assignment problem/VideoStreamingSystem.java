import java.time.LocalDate;
import java.util.Scanner;

public class VideoStreamingSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            
            for (int i = 0; i < n; i++) {
                String planType = scanner.next();
                String name = scanner.next();
                String startDateStr = scanner.next();
                
                // Parse start date
                LocalDate startDate = LocalDate.parse(startDateStr);
                
                // Determine validity days based on plan type and business rules
                int validityDays = switch (planType) {
                    case "BASIC" -> 30;     // Basic plan: valid for 30 days
                    case "STANDARD" -> 90;  // Standard plan: valid for 90 days
                    case "PREMIUM" -> 365; // Premium plan: valid for 365 days
                    default -> 0;
                };
                
                // Calculate renewal date by adding validity days to start date[cite: 15]
                LocalDate renewalDate = startDate.plusDays(validityDays);
                
                // Display Name: RenewalDate formatted as YYYY-MM-DD[cite: 15]
                System.out.println(name + ": " + renewalDate);
            }
        }
    }
}
