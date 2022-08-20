/**
 * 08/19/2022
 */
public class Leetcode33 {
    /**
     * Leetcode 33 - Search in Rotated Sorted Array (Medium)
     * TC: O(logn)
     * SC: O(1)
     * Left, mid and right stopping conditions are all considered in each loop.
     * Then, we should consider the relationships of mid, left and right to
     * determine whether rotation point is on the left or right to midpoint.
     * For rotation point in the left half and right half, cases can also be
     * divided according to the relationships of target, mid and one boundary.
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
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
        return -1;
    }
}
