/**
 * 07/28/2022
 */
public class Leetcode136 {
    /**
     * Leetcode 136 - Single Number (Easy)
     * TC: O(n)
     * SC: O(1)
     * XOR operation:
     * a ^ a ^ b = a ^ b ^ a = b ^ a ^ a = (a ^ a) ^ b = b.
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
