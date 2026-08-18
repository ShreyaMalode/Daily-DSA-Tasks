// Stock Buy And Sell
class Stock_Buy_And_Sell {

    /*
     * Problem Statement:
     * You are given an array of prices where prices[i]
     * is the price of a stock on the ith day.
     *
     * Choose one day to buy one stock and a different
     * day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve.
     *
     * If you cannot achieve any profit, return 0.
     *
     * Example:
     * Input:  [7, 1, 5, 3, 6, 4]
     * Output: 5
     *
     * Explanation:
     * Buy at 1 and sell at 6.
     * Profit = 6 - 1 = 5
     */

    public static int maxProfit(int[] prices) {

        // Starting me first price ko minimum price maanenge
        int minPrice = prices[0];

        // Starting me maximum profit 0 hai
        int maxProfit = 0;

        // Second day se check karenge
        for (int i = 1; i < prices.length; i++) {

            // Agar current price minimum se chhota hai
            // to ye better buying price hai
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // Current price par sell karne ka profit
            int profit = prices[i] - minPrice;

            // Maximum profit update karo
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(prices);

        System.out.println("Maximum Profit = " + result);
    }
}