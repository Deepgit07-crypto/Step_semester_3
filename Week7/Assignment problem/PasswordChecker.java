public class PasswordChecker {
    private final String password; // Stored privately and immutable (no getter provided)[cite: 5]

    // Constructor accepts the password once[cite: 5]
    public PasswordChecker(String password) {
        this.password = password;
    }

    // Evaluates and returns the strength rating based on length[cite: 5]
    public String getStrength() {
        if (password == null || password.length() < 6) {
            return "Weak"; // under 6 characters[cite: 5]
        } else if (password.length() <= 9) {
            return "Medium"; // 6 to 9 characters[cite: 5]
        } else {
            return "Strong"; // 10+ characters[cite: 5]
        }
    }
}
