class BookInventory {
    // Fields
    String title;
    String author;
    int copiesAvailable;

    // Constructor to initialize all three fields
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Instance method to print one formatted line
    public void printEntry() {
        System.out.println(this.title + " by " + this.author + " - " + this.copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        // Create an array of four BookInventory objects
        BookInventory[] books = new BookInventory[4];
        
        books[0] = new BookInventory("Clean Code", "Robert C. Martin", 3);
        books[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
        books[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
        books[3] = new BookInventory("Design Patterns", "GoF", 2);

        // Print each book entry in a loop
        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}