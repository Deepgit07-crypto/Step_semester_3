public class buysellstocks {
    public int maxProfit(int[] prices) {
        // Track the lowest price seen so far and the maximum profit achieved
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Walk through the array once (left to right)
        for (int price : prices) {
            // Update the lowest price seen so far
            if (price < minPrice) {
                minPrice = price;
            } 
            // Calculate potential profit and update max profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}