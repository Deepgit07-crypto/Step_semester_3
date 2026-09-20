public class matchdaygrid {

    // Helper method to compute the average for a single row (match)[cite: 10]
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }

        return sum / row.length;
    }

    // Main method to classify each match based on the threshold[cite: 10]
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            // Call rowAverage helper once per match[cite: 10]
            double avg = rowAverage(runsPerOver[i]);

            sb.append("Match ").append(i).append(": ");

            // Determine status based on threshold[cite: 10]
            if (avg >= threshold) {
                sb.append("Power Surge");
            } else {
                sb.append("Normal");
            }

            // Append separator if not the last match
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }
}
