/**
 * 07/30/2022
 */
public class Leetcode371 {
    /**
     * Leetcode 371 - Sum of Two Integers (Medium)
     * TC: O(1)
     * SC: O(1)
     * a + b = (a ^ b) + (a & b) << 1.
     * In the recursive function, b only calculate carry information.
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
