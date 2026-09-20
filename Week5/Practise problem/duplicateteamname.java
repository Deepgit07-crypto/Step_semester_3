public class duplicateteamname {
    public static String findDuplicateTeam(String[] teamNames) {
        // Use plain nested loops to compare every pair of team names[cite: 16]
        for (int i = 0; i < teamNames.length; i++) {
            // Only compare against names that come after the current one to avoid duplicate checks[cite: 16]
            for (int j = i + 1; j < teamNames.length; j++) {
                // Use .equals() for string content comparison[cite: 16]
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        
        // Return clear message if no duplicates exist[cite: 16]
        return "No Duplicates Found";
    }
}