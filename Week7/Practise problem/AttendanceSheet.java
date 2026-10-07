public class AttendanceSheet {

    // Private array - cannot be accessed directly from outside
    // Change line 4 to:
private final String[] students;

    // Number of students currently present
    private int presentCount;

    // Constructor
    public AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        presentCount = 0;
    }

    // Mark a student as present
    public void markPresent(String name) {

        // Check if the student is already present
        if (isPresent(name)) {
            return; // Do not add duplicates
        }

        // Check if the array is full
        if (presentCount >= students.length) {
            return;
        }

        // Add the student
        students[presentCount] = name;
        presentCount++;
    }

    // Return the number of present students
    public int getPresentCount() {
        return presentCount;
    }

    // Check whether a particular student is present
    public boolean isPresent(String name) {

        for (int i = 0; i < presentCount; i++) {

            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    // Main method
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: "
                + sheet.getPresentCount());

        System.out.println("Is Ben present? "
                + sheet.isPresent("Ben"));

        System.out.println("Is Chen present? "
                + sheet.isPresent("Chen"));
    }
}