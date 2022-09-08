/**
 * 09/07/2022
 */
public class Leetcode121 {
    /**
     * Leetcode 121 - Best Time to Buy and Sell Stock (Easy)
     * TC: O(n)
     * SC: O(1)
     * 1D Dynamic Programming with an integer:
     * Buy a stock can be considered as selling one with a negative profit.
     * Traverse the array and record highest negative profit until current
     * index and then calculate maximum profit with selling price.
     */
    public int maxProfit(int[] prices) {
        int dp = Integer.MIN_VALUE, res = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0) {
                res = Math.max(res, prices[i] + dp);
            }
            dp = Math.max(dp, -prices[i]);
        }
        return res < 0 ? 0 : res;
    }
}
