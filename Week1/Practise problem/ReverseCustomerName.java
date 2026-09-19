import java.util.Scanner;

public class ReverseCustomerName {

    // Method to reverse the customer name
    public static String reverseCustomerName(String customerName) {

        // Convert String to character array
        char[] characters = customerName.toCharArray();

        // Reverse the character array
        for (int i = 0; i < characters.length / 2; i++) {

            char temp = characters[i];

            characters[i] = characters[characters.length - 1 - i];

            characters[characters.length - 1 - i] = temp;
        }

        // Convert character array back to String
        return new String(characters);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take customer name as input
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        // Call the reverse method
        String reversedName = reverseCustomerName(customerName);

        // Display original and reversed names
        System.out.println("\nOriginal Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        sc.close();
    }
}