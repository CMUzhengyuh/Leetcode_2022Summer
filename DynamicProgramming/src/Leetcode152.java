/**
 * 09/07/2022
 */
public class Leetcode152 {
    /**
     * Leetcode 152 - Maximum Product Subarray (Medium)
     * TC: O(n)
     * SC: O(1)
     * 1D Dynamic Programming with fixed array length = 2:
     * dp[0] represent the minimum product while dp[1] represents the maximum.
     * Initialize the array as nums[0] and result also as num[0].
     * Traverse the array and update product according to the sign of nums[i].
     */
    public int maxProduct(int[] nums) {
        int[] dp = new int[2];
        dp[0] = Math.min(0, nums[0]);
        dp[1] = Math.max(0, nums[0]);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pos = 0, neg = 0;
            if (nums[i] == 0) {
                neg = 0;
                pos = 0;
            } else if (nums[i] < 0) {
                pos = Math.max(nums[i], nums[i] * dp[0]);
                neg = Math.min(nums[i], nums[i] * dp[1]);
            } else {
                pos = Math.max(nums[i], nums[i] * dp[1]);
                neg = Math.min(nums[i], nums[i] * dp[0]);
            }
            dp[0] = neg;
            dp[1] = pos;
            res = Math.max(dp[1], res);
        }
        return res;
    }
}
