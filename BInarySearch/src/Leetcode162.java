/**
 * 08/20/2022
 */
public class Leetcode162 {
    /**
     * Leetcode 162 - Find the Duplicate Number (Medium)
     * TC: O(nlogn)
     * SC: O(1)
     * Consider the relationships of nums[mid] and nums[mid + 1]:
     * (1) If nums[mid] > nums[mid + 1], there is a peak in the left interval.
     * (2) Else, there is a peak in the right interval.
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
