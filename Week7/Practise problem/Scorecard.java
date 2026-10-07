class ScorecardData {

    private final boolean[] results;
    private int recordedAnswers;

    public ScorecardData(int totalQuestions) {
        results = new boolean[totalQuestions];
        recordedAnswers = 0;
    }

    public void recordAnswer(boolean isCorrect) {

        if (recordedAnswers >= results.length) {
            return;
        }

        results[recordedAnswers] = isCorrect;
        recordedAnswers++;
    }

    public int getScore() {

        int score = 0;

        for (int i = 0; i < recordedAnswers; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}


public class Scorecard {

    public static void main(String[] args) {

        ScorecardData sc = new ScorecardData(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Final Score = " + sc.getScore());
    }
}
