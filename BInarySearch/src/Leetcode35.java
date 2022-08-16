/**
 * 08/16/2022
 */
public class Leetcode35 {
    /**
     * Leetcode 35 - Search Insert Position (Easy)
     * TC: O(logn)
     * SC: O(1)
     * Pay attention to 0 and nums.length cases.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums.length == 0 || nums[0] > target) return 0;
        if (nums[right] < target) return nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * Corner Case: EMPTY ARRAY
     * Corner Case: nums[0] < target AND nums[nums.length - 1] > target
     */
}
