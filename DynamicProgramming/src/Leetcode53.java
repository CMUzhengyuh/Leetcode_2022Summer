/**
 * 09/07/2022
 */
public class Leetcode53 {
    /**
     * Leetcode 53 - Climbing Stairs (Medium)
     * TC: O(n)
     * SC: O(1)
     * 1D Dynamic Programming with an integer:
     * If partial sum < 0, abandon existing partial sum. Else, add current the
     * the partial sum, record the maximum number in the process.
     */
    public int maxSubArray(int[] nums) {
        int dp = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(dp, 0) + nums[i];
            res = Math.max(dp, res);
        }
        return res;
    }
}
