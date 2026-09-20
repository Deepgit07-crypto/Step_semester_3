public class duplicateplayer {
    public static String findDuplicatePick(String[] playerNames) {
        // Handle edge case for null or empty array
        if (playerNames == null || playerNames.length == 0) {
            return "No Duplicates Found";
        }

        // Compare each name against the names that come after it using nested loops[cite: 10]
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                // Check for string equality (case-sensitive)[cite: 10]
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        // Return message if no duplicates exist[cite: 10]
        return "No Duplicates Found";
    }
}