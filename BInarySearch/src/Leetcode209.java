/**
 * 08/20/2022
 */
public class Leetcode209 {
    /**
     * Leetcode 209 - Minimum Size Subarray Sum (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * Calculate the prefix of the source array, the conduct a binary search
     * to every possible length of the result and verify it.
     * *** Two pointers is optimal solution with O(n).
     */
    public int minSubArrayLen(int target, int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int left = 0, right = nums.length, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean ok = false;
            for (int i = 0; i < nums.length + 1 - mid; i++) {
                if (prefix[i + mid] - prefix[i] >= target) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
