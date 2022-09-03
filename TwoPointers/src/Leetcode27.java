/**
 * 09/03/2022
 */
public class Leetcode27 {
    /**
     * Leetcode 27 - Remove Element (Easy)
     * TC: O(n)
     * SC: O(1)
     * If the right pointer encounters non-target elements, swap it with left.
     */
    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                swap(nums, left++, right);
            }
            right++;
        }
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
