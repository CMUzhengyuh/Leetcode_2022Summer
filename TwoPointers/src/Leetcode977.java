/**
 * 09/03/2022
 */
public class Leetcode977 {
    /**
     * Leetcode 977 - Squares of a Sorted Array (Easy)
     * TC: O(n)
     * SC: O(1)
     * (1) Calculate the square to the original array.
     * (2) Use left and right pointers from two boundaries and fill the result
     *     array reversely with the larger value in two pointers until the end.
     */
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int left = 0, right = nums.length - 1;
        while (index >= 0) {
            if (nums[left] > nums[right]) {
                res[index--] = nums[left++];
            } else {
                res[index--] = nums[right--];
            }
        }
        return res;
    }
}
