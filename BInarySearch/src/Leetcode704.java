/**
 * 08/16/2022
 */
public class Leetcode704 {
    /**
     * Leetcode 704 - Binary Search (Easy)
     * TC: O(logn)
     * SC: O(1)
     * BinarySearch template.
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
