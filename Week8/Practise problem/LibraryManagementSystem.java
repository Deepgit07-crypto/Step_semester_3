import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                return;
            }
            
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            
            LocalDate currentDate = LocalDate.of(2023, 10, 26);
            Pattern pattern = Pattern.compile("^([A-Z]+)\\s+\"(.*)\"$");
            
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                
                if (matcher.find()) {
                    String itemType = matcher.group(1);
                    String itemTitle = matcher.group(2);
                    
                    // Converted to a modern switch expression to resolve both warnings
                    int borrowingDays = switch (itemType) {
                        case "BOOK" -> 14;
                        case "DVD" -> 7;
                        case "MAGAZINE" -> 3;
                        default -> 0;
                    };
                    
                    LocalDate dueDate = currentDate.plusDays(borrowingDays);
                    System.out.println(itemTitle + ": " + dueDate);
                }
            }
        }
    }
}
