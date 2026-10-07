class PiggyBankAccount {

    private int savings;
    private final String id;

    // Constructor
    public PiggyBankAccount(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposit money
    public void deposit(int amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    // Withdraw money
    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
            return true;
        }

        return false;
    }

    // Get savings
    public int getSavings() {
        return savings;
    }

    // Get ID
    public String getId() {
        return id;
    }
}


public class PiggyBank {

    public static void main(String[] args) {

        PiggyBankAccount pb = new PiggyBankAccount("PB-1");

        System.out.println("Piggy Bank ID: " + pb.getId());
        System.out.println("Initial savings: " + pb.getSavings());

        pb.deposit(100);
        System.out.println("After deposit(100) -> savings = "
                + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdraw(30) -> savings = "
                + pb.getSavings());

        boolean result = pb.withdraw(500);

        if (!result) {
            System.out.println("withdraw(500) -> rejected, savings stays "
                    + pb.getSavings());
        }
    }
}
