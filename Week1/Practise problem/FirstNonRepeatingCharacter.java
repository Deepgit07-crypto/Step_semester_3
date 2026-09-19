import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character
    public static char findFirstNonRepeatingChar(String text) {

        // HashMap to store character frequencies
        HashMap<Character, Integer> frequency = new HashMap<>();

        // Count frequency of every character
        for (char ch : text.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Scan from left to right
        for (char ch : text.toCharArray()) {

            if (frequency.get(ch) == 1) {
                return ch;
            }
        }

        // Return '\0' if no non-repeating character exists
        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();

        // Find first non-repeating character
        char result = findFirstNonRepeatingChar(text);

        // Display result
        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println(
                "First Non-Repeating Character: '" + result + "'"
            );
        }

        sc.close();
    }
}