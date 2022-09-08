/**
 * 09/07/2022
 */
public class Leetcode494 {
    /**
     * Leetcode 494 - Target Sum (Medium)
     * TC: O(n * target)
     * SC: O(n * target)
     * Calculate the sum of given array first, check if target is not larger
     * than sum or the difference of target and sum is odd. If so, there should
     * be no such path.
     * 2D Dynamic Programming:
     * Dimension 1: [0, nums.length + 1] represent the dimension of input.
     * Dimension 2: [0, (sum - target) / 2 + 1] represents partial sum.
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) % 2 != 0 || sum < target) {
            return 0;
        }
        target = (sum - target) / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (dp[i - 1][j] > 0) {
                    if (j + nums[i - 1] <= target) {
                        dp[i][j + nums[i - 1]] += dp[i - 1][j];
                    }
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
