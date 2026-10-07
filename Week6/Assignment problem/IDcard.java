class IdCard {
    // Fields
    String name;
    int booksIssued;

    // Constructor setting both fields
    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        // Create one IdCard object for Ravi
        IdCard ravi = new IdCard("Ravi", 0);

        // Assign a second variable to point to that same object
        IdCard duplicate = ravi;

        // Through the second variable, change booksIssued
        duplicate.booksIssued = 3;

        // Print the field's value as seen through the first variable and reference equality check
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Create a third, separate IdCard object with identical field values
        IdCard separate = new IdCard("Ravi", 3);

        // Print whether it is == to the first
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}