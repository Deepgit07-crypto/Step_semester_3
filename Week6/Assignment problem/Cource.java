class Course {
    // Fields
    String code;
    String title;
    int credits;
    int labCredits;

    // Four-argument constructor setting all fields directly
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Three-argument constructor chaining via this(...) with labCredits set to 0
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    // Returns total credits (credits + labCredits)
    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        // Course 1: Theory-only (3-arg constructor)
        Course course1 = new Course("21CSC201J", "Data Structures", 4);

        // Course 2: Theory + Lab (4-arg constructor)
        Course course2 = new Course("21CSC205L", "DSA Lab", 3, 1);

        // Output formatting matching the problem statement
        System.out.println(course1.code + " total credits: " + course1.totalCredits());
        System.out.println(course2.code + " total credits: " + course2.totalCredits());
    }
}