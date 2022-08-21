/**
 * 08/20/2022
 */
public class Leetcode287 {
    /**
     * Leetcode 287 - Find the Duplicate Number (Medium)
     * TC: O(nlogn)
     * SC: O(1)
     * Rewrite the problem to  find the number x in the array that satisfy:
     * The amount of numbers smaller than or equals to x is larger than x.
     * This can works in that only the duplicate number emerges more than once.
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1, right = n, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}
