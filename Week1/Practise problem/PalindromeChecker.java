import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative comparison
    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive comparison
    public static boolean isPalindromeRecursive(String text) {

        // Base case
        if (text.length() <= 1) {
            return true;
        }

        // Compare first and last characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Recursively check the remaining substring
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Array reversal
    public static boolean isPalindromeArrayReversal(String text) {

        // Convert string to character array
        char[] original = text.toCharArray();

        // Create another array for reversed string
        char[] reversed = new char[original.length];

        // Reverse the array
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        // Compare original and reversed arrays
        for (int i = 0; i < original.length; i++) {

            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        // Call all three approaches
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        // Display results
        System.out.println("\n===== PALINDROME CHECK RESULTS =====");

        System.out.println("Input: " + text);

        System.out.println("Iterative: "
                + (iterative ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: "
                + (recursive ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: "
                + (arrayReversal ? "Palindrome" : "Not Palindrome"));

        // Verify that all approaches agree
        if (iterative == recursive && recursive == arrayReversal) {
            System.out.println("\nAll three approaches agree.");
        } else {
            System.out.println("\nThe approaches do not agree.");
        }

        sc.close();
    }
}