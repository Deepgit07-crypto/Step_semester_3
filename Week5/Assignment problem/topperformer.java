public class topperformer {
    public static String findMinMaxSpread(int[] scores) {
        // Initialize running variables for min and max with the first element[cite: 10]
        int min = scores[0];
        int max = scores[0];

        // Find the minimum and maximum in a single pass through the array[cite: 10]
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        // Calculate the spread[cite: 10]
        int spread = max - min;

        // Return the formatted string reporting min, max, and spread together[cite: 10]
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }
}