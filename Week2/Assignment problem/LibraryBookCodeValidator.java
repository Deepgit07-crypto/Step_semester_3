public class LibraryBookCodeValidator {

    // Task 1: Normalize raw ISBN-style code string
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }

        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase only the first 3 characters, leave the rest untouched
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    // Task 2: Validate and format normalized code string
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            String result = "Invalid: wrong length";
            System.out.println(result);
            return result;
        }

        // Check if the first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                String result = "Invalid: publisher code must be 3 letters";
                System.out.println(result);
                return result;
            }
        }

        // Check if the remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                String result = "Invalid: non-digit body";
                System.out.println(result);
                return result;
            }
        }

        // Extract components using substring
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        // Build formatted display line using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year);
        sb.append(" | CATALOG: ").append(catalog);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        String raw1 = " pen2026004251 ";
        String normalized1 = normalizeCode(raw1);
        validateAndFormat(normalized1);

        // Sample Test Case 2
        String raw2 = "12N2026004251";
        String normalized2 = normalizeCode(raw2);
        validateAndFormat(normalized2);
    }
}