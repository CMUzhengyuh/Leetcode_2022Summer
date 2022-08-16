/**
 * 08/16/2022
 */
public class Leetcode69 {
    /**
     * Leetcode 69 - Sqrt(x) (Easy)
     * TC: O(logn)
     * SC: O(1)
     * Record the maximum value that satisfy mid ^ 2 <= x.
     * Pay attention to the overflow problem.
     */
    public int mySqrt(int x) {
        int left = 0, right = x, res = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                res = (int) mid;
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return res;
    }
}
