/**
 * 09/03/2022
 */
public class Leetcode283 {
    /**
     * Leetcode 283 - Move Zeroes (Easy)
     * TC: O(n)
     * SC: O(1)
     * At most # non-zero number times of operations by swapping these numbers
     * in the right pointer with left pointer.
     */
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left++, right);
            }
            right++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
