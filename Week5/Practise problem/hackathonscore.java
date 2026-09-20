import java.util.Arrays;

public class hackathonscore {
    // Modifies the caller's array directly in place without returning a value
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        
        // Print the final array using Arrays.toString(...)
        System.out.println(Arrays.toString(scores));
    }
}