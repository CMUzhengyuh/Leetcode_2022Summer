/**
 * 07/28/2022
 */
public class Leetcode461 {
    /**
     * Leetcode 461 - Hamming Distance (Easy)
     * TC: O(1)
     * SC: O(1)
     * Calculate the number of '1's of the numbers' XOR result.
     */
    public int hammingDistance(int x, int y) {
        int num = x ^ y, res = 0;
        while (num != 0) {
            num &= num - 1;
            res++;
        }
        return res;
    }
}
