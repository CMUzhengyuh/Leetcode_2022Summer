/**
 * 09/07/2022
 */
public class Leetcode746 {
    /**
     * Leetcode 746 - Climbing Stairs (Easy)
     * TC: O(n)
     * SC: O(1)
     * 1D Dynamic Programming with fixed array length = 2:
     * dp[n] = min(dp[n - 1] + cost[n - 1], dp[n - 2] + cost[n - 2]).
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            int cur = Math.min(dp[0] + cost[i - 2], dp[1] + cost[i - 1]);
            dp[0] = dp[1];
            dp[1] = cur;
        }
        return dp[1];
    }
}
