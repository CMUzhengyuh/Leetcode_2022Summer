/**
 * 08/22/2022
 */
public class Leetcode410 {
    /**
     * Leetcode 410 - Split Array Largest Sum (Hard)
     * TC: O(nlogS), S = Sum of nums
     * SC: O(n)
     * First, calculate the prefix of array elements.
     * The result locates in the range of largest element and sum of array.
     * Perform a binary search for a given value and calculate the minimum
     * segment numbers of the array to determine whether the mid value is
     * smaller or larger than the result.
     */
    public int splitArray(int[] nums, int m) {
        int[] prefix = new int[nums.length + 1];
        int left = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = nums[i] + prefix[i];
            left = Math.max(left, nums[i]);
        }
        int right = prefix[nums.length];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sub = 1, i = 0, j = 0;
            while (j <= nums.length) {
                if (prefix[j] - prefix[i] > mid) {
                    i = j - 1;
                    sub++;
                }
                j++;
            }
            if (sub <= m) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
