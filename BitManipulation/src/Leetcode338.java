/**
 * 07/29/2022
 */
public class Leetcode338 {
    /**
     * Leetcode 338 - Counting Bits (Medium)
     * TC: O(n)
     * SC: O(n)
     * # Bits of number x = 1 + # Bits of number x & (x - 1).
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}
