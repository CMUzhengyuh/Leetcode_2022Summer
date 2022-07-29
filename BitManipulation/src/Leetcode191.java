/**
 * 07/28/2022
 */
public class Leetcode191 {
    /**
     * Leetcode 191 - Number of 1 Bits (Easy)
     * TC: O(1)
     * SC: O(1)
     * Trick to remove the last significant '1' in binary presentation:
     * n = n & (n - 1)
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
