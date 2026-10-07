public class Employee {
    // Fields
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns using constructor chaining via this(...)
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    // Method to print profile fields on one line
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        // Create permanent employee
        Employee emp1 = new Employee("E-101", "Divya", 65000.0);
        
        // Create intern employee
        Employee emp2 = new Employee("E-102", "Arjun");

        // Print profiles
        emp1.printProfile();
        emp2.printProfile();
    }
}