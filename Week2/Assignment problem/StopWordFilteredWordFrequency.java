import java.util.*;

public class StopWordFilteredWordFrequency {

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Define the fixed list of stop words
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
        ));

        // Normalize text: convert to lowercase and strip punctuation (periods and commas) using replace()
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");

        // Split the cleaned text into words using split("\\s+")
        String[] words = cleaned.split("\\s+");

        // Count frequency of remaining unique words
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            // Skip empty strings and stop words
            if (!word.isEmpty() && !stopWords.contains(word)) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        // Convert map entries to a list for sorting
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCounts.entrySet());

        // Sort entries by count in descending order
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print each unique word with its count
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Sample Input
        String input = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(input);
    }
}