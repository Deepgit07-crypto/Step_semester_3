import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    // Method to find the longest streak
    public static void findLongestStreak(String signalLog) {

        if (signalLog.length() == 0) {
            System.out.println("Signal log is empty.");
            return;
        }

        int currentStreak = 1;
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        char longestColor = signalLog.charAt(0);

        // Scan the signal log
        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                // Same color continues
                currentStreak++;
            } else {
                // New color starts
                currentStreak = 1;
            }

            // Check if current streak is the longest
            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = signalLog.charAt(i);
            }
        }

        // Display result
        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + longestStreak + " times");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take signal log as input
        System.out.print("Enter signal log (R/Y/G): ");
        String signalLog = sc.nextLine();

        // Convert input to uppercase
        signalLog = signalLog.toUpperCase();

        // Find longest streak
        findLongestStreak(signalLog);

        sc.close();
    }
}