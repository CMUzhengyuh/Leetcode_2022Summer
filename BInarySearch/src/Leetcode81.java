/**
 * 08/19/2022
 */
public class Leetcode81 {
    /**
     * Leetcode 81 - Search in Rotated Sorted Array II (Medium)
     * TC: O(n)
     * SC: O(1)
     * This is the follow up problem for Leetcode 33.
     * To avoid the influence of depulicates:
     * When nums[left] = nums[right] = nums[mid], move left and right one step.
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            }
            while (left < mid && nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            }
            if (nums[mid] >= nums[left] && nums[mid] >= nums[right]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
