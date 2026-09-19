public class PhoneNumberMasker {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            String errorMessage = "Invalid phone number";
            System.out.println(errorMessage);
            return errorMessage;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phone.substring(6));
        sb.insert(6, "-");

        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        // Sample Test Cases
        maskPhoneNumber("9876543210");
        maskPhoneNumber("98765");
    }
}