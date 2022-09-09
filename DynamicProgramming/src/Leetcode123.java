/**
 * 09/08/2022
 */
public class Leetcode123 {
    /**
     * Leetcode 123 - Best Time to Buy and Sell Stock III (Hard)
     * TC: O(n)
     * SC: O(n)
     * 2D Dynamic Programming:
     * Dimension 1: [0, prices.length] represent the dimension of input.
     * Dimension 2: 0 represents holding the first time, 1 represents sold
     *              the first time, 2 represents holding the second time,
     *              3 represents selling for the second time.
     * Traverse the profit array and the status function:
     * (1) status 0 can be either holding an older one or buy in current time.
     * (2) status 1 can be doing nothing or selling existing stock.
     * (3) status 2 and status 3 is similar to status 0 and status 1.
     * The result is the maximum among status 1, status 3 or 0.
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][2] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return Math.max(0, Math.max(dp[prices.length - 1][1], dp[prices.length - 1][3]));
    }
}
