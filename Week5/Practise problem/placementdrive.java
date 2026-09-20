import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class placementdrive {

    public static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // Calculates composite score (e.g., CGPA * 10 + coding score)[cite: 19]
        public double getCompositeScore() {
            return (this.cgpa * 10.0) + this.codingScore;
        }

        // Implement Comparable for descending sort by composite score[cite: 19]
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    // CGPA-only quick filter (e.g., threshold >= 8.0)[cite: 19]
    public static boolean isEligible(double cgpa) {
        return cgpa >= 8.0;
    }

    // Combined CGPA and coding score filter for borderline cases[cite: 19]
    public static boolean isEligible(double cgpa, int codingScore) {
        if (isEligible(cgpa)) {
            return true;
        }
        // Borderline CGPA >= 6.5 with strong coding score >= 60[cite: 19]
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        // Filter eligible candidates using overloaded methods[cite: 19]
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        // Convert list to array and sort using Comparable logic[cite: 19]
        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[shortlisted.size()]);
        Arrays.sort(shortlistedArray);

        // Format final ranked output string[cite: 19]
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            Candidate c = shortlistedArray[i];
            sb.append(i + 1)
              .append(". ")
              .append(c.name)
              .append(" (")
              .append(c.getCompositeScore())
              .append(")");

            if (i < shortlistedArray.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }
}