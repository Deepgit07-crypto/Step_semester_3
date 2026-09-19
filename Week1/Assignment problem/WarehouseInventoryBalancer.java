import java.util.Scanner;

public class WarehouseInventoryBalancer {

    // Method to analyze inventory
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        // Calculate total of Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
        }

        // Calculate total of Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
        }

        // Check whether both sections are balanced
        String status;

        if (totalA == totalB) {
            status = "Balanced";
        } else {
            status = "Not Balanced";
        }

        // Find highest quantity
        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        // Check Section A
        for (int i = 1; i < sectionA.length; i++) {

            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        // Check Section B
        for (int i = 0; i < sectionB.length; i++) {

            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        // Display result
        System.out.println("\n===== WAREHOUSE INVENTORY REPORT =====");

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);
        System.out.println("Status: " + status);

        System.out.println("Highest Quantity: " + highestQuantity
                + " (" + highestSection
                + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of items
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        // Create arrays
        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        // Input Section A
        System.out.println("Enter quantities for Section A:");

        for (int i = 0; i < n; i++) {
            sectionA[i] = sc.nextInt();
        }

        // Input Section B
        System.out.println("Enter quantities for Section B:");

        for (int i = 0; i < n; i++) {
            sectionB[i] = sc.nextInt();
        }

        // Analyze inventory
        analyzeInventory(sectionA, sectionB);

        sc.close();
    }
}