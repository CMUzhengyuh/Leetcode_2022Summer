/**
 * 10/02/2022
 */
public class Leetcode2221 {
    /**
     * Leetcode 2221 - Find Triangular Sum of an Array (Medium)
     * TC: O(n ^ 2)
     * SC: O(1)
     * Stimulate the whole process by reusing the source array.
     */
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}
