/**
 * 07/28/2022
 */
public class Leetcode231 {
    /**
     * Leetcode 231 - Power of Two (Easy)
     * TC: O(1)
     * SC: O(1)
     * Also use the trick to remove last '1' to see if the result equals to 0:
     * n = n & (n - 1)
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    /**
     * Corner Case 1: 0
     * Corner Case 2: NEGATIVE INTEGER
     */
}
