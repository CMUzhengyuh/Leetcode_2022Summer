/**
 * 09/04/2022
 */
public class Leetcode713 {
    /**
     * Leetcode 713 - Subarray Product Less Than K (Medium)
     * TC: O(n)
     * SC: O(1)
     * Traverse the array and record the partial product range from left to i:
     * (1) Multiple nums[i] first.
     * (2) Check if product is strictly leff than K, if not move left pointer.
     * (3) Add the number of sub-array ends with nums[i] to the result.
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, left = 0, prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k && left <= i) {
                prod /= nums[left++];
            }
            res += (i + 1 - left);
        }
        return res;
    }
}
