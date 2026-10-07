public class Locker {

    // Locker number cannot be changed
    private final int lockerNumber;

    // Combination is private and cannot be read from outside
    private String combinationCode;

    // Constructor
    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    // Change combination only if current code is correct
    public boolean changeCode(String currentCode, String newCode) {

        // Check old code first
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            return true;
        }

        // Wrong current code
        return false;
    }

    // Getter for locker number is allowed
    public int getLockerNumber() {
        return lockerNumber;
    }

    // Main method
    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        // Correct current code
        if (l.changeCode("1234", "5678")) {
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Code change rejected.");
        }

        // Wrong current code
        if (l.changeCode("0000", "9999")) {
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Code change rejected.");
        }

        System.out.println("Locker Number: " + l.getLockerNumber());

        // There is NO getCombinationCode() method.
    }
}
