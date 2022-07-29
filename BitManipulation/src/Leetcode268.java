/**
 * 07/28/2022
 */
public class Leetcode268 {
    /**
     * Leetcode 268 - Missing Number (Easy)
     * TC: O(n)
     * SC: O(1)
     * Assume the missing one is m among [0, n]:
     * input array XOR [0, n] = (0 ^ 0) ^ ... m ^ (m + 1 ^ m + 1) ... = m.
     */
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}
