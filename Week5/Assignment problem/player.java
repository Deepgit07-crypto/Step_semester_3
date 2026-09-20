import java.util.Arrays;

class Player implements Comparable<Player> {
    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    // Overloaded rule 1: Established players qualify on experience alone (matches >= 10)
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded rule 2: Combined matches and fitness check (matches >= 5 and not injured)
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Sort by fantasy points (batting average) in descending order
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    // Static method to filter, sort, and return ranked string
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        // Count draftable players
        int count = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                count++;
            }
        }

        // Collect draftable players into array
        Player[] draftable = new Player[count];
        int index = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable[index++] = p;
            }
        }

        // Sort using Comparable implementation
        Arrays.sort(draftable);

        // Format output string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            sb.append(i + 1).append(". ").append(draftable[i].getName());
            if (i < draftable.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }
}