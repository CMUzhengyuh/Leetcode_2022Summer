/**
 * 08/18/2022
 */
public class Leetcode34 {
    /**
     * Leetcode 34 - Find First and Last Position of Element in Sorted Array (Medium)
     * TC: O(logn)
     * SC: O(1)
     * Search the array twice and locate the left and right bound of target.
     * LeftBound: when mid number is smaller than target, search rightwards.
     * RightBound: when mid number is greater than target, search leftwards.
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
            }
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
