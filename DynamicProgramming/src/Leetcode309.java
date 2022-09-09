/**
 * 09/07/2022
 */
public class Leetcode309 {
    /**
     * Leetcode 309 - Best Time to Buy and Sell Stock with Cooldown (Medium)
     * TC: O(n)
     * SC: O(n)
     * 2D Dynamic Programming:
     * Dimension 1: [0, prices.length] represent the dimension of input.
     * Dimension 2: 0 represents holding a stock, 1 represents selling and
     *              2 represents available to buy in next time slot.
     * Traverse the profit array and the status function:
     * (1) Status 0 can be either holding an older one or buying currently.
     * (2) Status 1 can only sell in current time slot.
     * (3) Status 2 can be the next time of selling or not do anything.
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
