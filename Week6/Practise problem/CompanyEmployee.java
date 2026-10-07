public class CompanyEmployee {
    // Instance fields for individual employee details
    private String empName;
    private double salary;

    // Static fields shared across all CompanyEmployee objects
    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    // Constructor that increments employeeCount on each instantiation
    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method printing company name and employee count without accessing instance fields
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        // Create three CompanyEmployee objects
        CompanyEmployee emp1 = new CompanyEmployee("Alice", 50000.0);
        CompanyEmployee emp2 = new CompanyEmployee("Bob", 60000.0);
        CompanyEmployee emp3 = new CompanyEmployee("Charlie", 55000.0);

        // Call printCompanyInfo() directly through the class name
        CompanyEmployee.printCompanyInfo();
    }
}