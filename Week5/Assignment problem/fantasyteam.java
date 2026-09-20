public class fantasyteam {
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        // Multiply captain's score by 2x in-place[cite: 10]
        playerScores[captainIndex] *= 2.0;

        // Multiply vice-captain's score by 1.5x in-place[cite: 10]
        playerScores[viceCaptainIndex] *= 1.5;
    }
}
