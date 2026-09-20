public class podiumfinder {
    public static int[] findTopThreeScores(int[] scores) {
        // Track top 3 highest scores initialized to minimum possible value
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        // Scan the array once, left to right, without sorting[cite: 17]
        for (int score : scores) {
            if (score >= first) {
                // New score beats or ties for 1st place: shift values down[cite: 17]
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                // New score beats or ties for 2nd place: shift 2nd down to 3rd[cite: 17]
                third = second;
                second = score;
            } else if (score > third) {
                // New score beats 3rd place[cite: 17]
                third = score;
            }
        }

        // Return top 3 scores in descending order[cite: 17]
        return new int[]{first, second, third};
    }
}