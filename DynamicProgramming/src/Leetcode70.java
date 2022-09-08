/**
 * 09/07/2022
 */
public class Leetcode70 {
    /**
     * Leetcode 70 - Climbing Stairs (Easy)
     * TC: O(n)
     * SC: O(1)
     * 1D Dynamic Programming with fixed array length = 2:
     * dp[0] represents the result of current - 2.
     * dp[1] represents the result of current - 1.
     * Every time calculate the new result and evict the dp[0].
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        n -= 2;
        int[] dp = new int[]{1, 2};
        while (n-- != 0) {
            int cur = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = cur;
        }
        return dp[1];
    }
}
