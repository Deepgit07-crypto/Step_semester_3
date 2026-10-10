import java.util.Scanner;

public class EmployeeBonusSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            double grandTotal = 0.0;
            
            for (int i = 0; i < n; i++) {
                String employeeType = scanner.next();
                String name = scanner.next();
                double monthlySalary = scanner.nextDouble();
                
                // Calculate bonus based on employee type and business rules using a rule switch
                double bonus = switch (employeeType) {
                    case "FULLTIME" -> monthlySalary * 0.10; // Full-time employees get 10% of their monthly salary
                    case "PARTTIME" -> monthlySalary * 0.05; // Part-time employees get 5% of their monthly salary
                    case "INTERN" -> 2000.0;                // Interns get a fixed bonus of ₹2,000
                    default -> 0.0;
                };
                
                grandTotal += bonus;
                
                // Display each employee's bonus formatted to two decimal places
                System.out.printf("%s: %.2f%n", name, bonus);
            }
            
            // Display total bonus paid formatted to two decimal places[cite: 14]
            System.out.printf("Total Bonus: %.2f%n", grandTotal);
        }
    }
}
