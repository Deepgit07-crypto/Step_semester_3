class MessWallet {
    // Private double balance field to prevent direct modification outside the class
    private double balance;

    // Public constructor accepting an opening balance
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance provided. Setting balance to 0.");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    // Public method topUp to add funds
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Top-up must be greater than 0.");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    // Public method deduct to subtract funds safely
    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduct amount must be greater than 0.");
        } else if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
            System.out.println("Deducted: " + amount);
        }
    }

    // Read-only getter method for balance
    public double getBalance() {
        return this.balance;
    }

    // Main method matching the sample test case
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
