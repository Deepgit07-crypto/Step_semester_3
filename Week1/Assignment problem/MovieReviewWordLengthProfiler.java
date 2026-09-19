import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    // Method to classify word lengths
    public static void classifyWordLengths(String review) {

        // Split the review into words
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        // Check each word
        for (String word : words) {

            // Remove punctuation from the word
            word = word.replaceAll("[^a-zA-Z]", "");

            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } 
            else if (length >= 5 && length <= 8) {
                mediumCount++;
            } 
            else if (length >= 9) {
                longCount++;
            }
        }

        // Display result
        System.out.println("\n===== WORD LENGTH PROFILE =====");
        System.out.println("Short: " + shortCount);
        System.out.println("Medium: " + mediumCount);
        System.out.println("Long: " + longCount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take review as input
        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        // Classify word lengths
        classifyWordLengths(review);

        sc.close();
    }
}