public class StudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Name: " + fields[0].trim() + " | Roll No: " + fields[1].trim() + " | Dept: " + fields[2].trim());
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Valid input
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");

        // Test Case 2: Invalid input
        parseStudentRecord("Ananya Verma,CSE");
    }
}
