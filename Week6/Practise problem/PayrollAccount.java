public class PayrollAccount {
    // Private fields to prevent direct modification outside the class
    private double basicSalary;
    private double bonus;

    // Constructor accepting basic salary
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0; // Initialize bonus to 0
    }

    // Method to add bonus
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount. Must be greater than 0.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Method to deduct tax as a percentage from basicSalary
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage. Must be between 0 and 100.");
        } else {
            this.basicSalary -= (this.basicSalary * percent / 100.0);
            System.out.println("Tax deducted: " + (int) percent + "%");
        }
    }

    // Read-only getter for net salary
    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        // Sample execution based on the image requirements
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}