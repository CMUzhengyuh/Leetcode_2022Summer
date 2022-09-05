public class Leetcode11 {
    /**
     * Leetcode 11 - Container With Most Water (Medium)
     * TC: O(n)
     * SC: O(1)
     * Use two pointers start from two sides separately:
     * Move the pointer with smaller height towards another every time.
     * This method will lose any possible maximum water in that:
     * We assume that current boundary is i, j and height[i] < height[j]:
     * If we move j by 1 step, the next possible result is:
     * min(height[i], height[j - 1]) * (j - i - 1) <= height[i] * (j - i - 1)
     *                                             < height[i] * (j - 1),
     * which is the answer of current position i, j. Hence, we can only move
     * the smaller height boundary to get a possible larger result.
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, height[i] * (j - i++));
            } else {
                res = Math.max(res, height[j] * (j-- - i));
            }
        }
        return res;
    }
}
