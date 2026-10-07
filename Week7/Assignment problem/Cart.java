public class Cart {
    private final String cartId;      // Fixed cart ID set upon creation[cite: 9]
    private final int[] prices;       // Private array to store prices[cite: 9]
    private int itemCount;            // Tracks number of items added[cite: 9]

    // Constructor taking fixed cart ID and maximum capacity[cite: 9]
    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new int[capacity];
        this.itemCount = 0;
    }

    // Adds an item price to the cart if capacity allows[cite: 9]
    public void addItem(int price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    // Computes and returns total sum on request[cite: 9]
    public int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    // Read-only getter for item count[cite: 9]
    public int getItemCount() {
        return itemCount;
    }

    // Read-only getter for cart ID
    public String getCartId() {
        return cartId;
    }
}