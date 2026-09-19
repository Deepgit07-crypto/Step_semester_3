public class TransactionReferenceValidator {

    // Task 1: Normalize raw reference string
    public static String normalizeReference(String raw) {
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

    // Task 2: Validate and format normalized reference string
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            String result = "Invalid: wrong length";
            System.out.println(result);
            return result;
        }

        // Check if the first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                String result = "Invalid: bank code must be 3 letters";
                System.out.println(result);
                return result;
            }
        }

        // Check if the remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                String result = "Invalid: non-digit body";
                System.out.println(result);
                return result;
            }
        }

        // Extract components using substring
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        // Build formatted string using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        sb.append(" | SEQ: ").append(seq);

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        String raw1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(raw1);
        validateAndFormat(normalized1);

        // Sample Test Case 2
        String raw2 = "12F03022600042";
        String normalized2 = normalizeReference(raw2);
        validateAndFormat(normalized2);
    }
}