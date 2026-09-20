public class hackathonseatinggrid {

    // Helper method to calculate the average of a single row[cite: 18]
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        
        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        
        return sum / row.length;
    }

    // Classifies each row based on whether its average meets the threshold[cite: 18]
    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            // Call rowAverage once per row[cite: 18]
            double avg = rowAverage(seatingScores[i]);
            
            // Determine zone type based on threshold[cite: 18]
            String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";

            result.append("Row ").append(i).append(": ").append(zone);

            // Add separator between rows[cite: 18]
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}