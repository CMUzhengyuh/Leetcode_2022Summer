/**
 * 08/20/2022
 */
public class Leetcode153 {
    /**
     * Leetcode 153 - Find Minimum in Rotated Sorted Array (Medium)
     * TC: O(logn)
     * SC: O(1)
     * Utilize the pattern of the array to determine to search in the left
     * or the right range to the middle point. In case of the medium case,
     * consider the continuous three elements within [mid - 1, mid + 1].
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid >= 1 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[left] <= nums[mid] && nums[right] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
