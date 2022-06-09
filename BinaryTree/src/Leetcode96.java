/**
 * 06/08/2022
 */
public class Leetcode96 {
    /**
     * Leetcode 96 - Unique Binary Search Trees (Medium)
     * TC: O(n)
     * SC: O(n)
     * Refer to total number of BST with n nodes as F(n):
     * F(n) = n (n <= 2)
     *      = F(0) * F(n - 1) + F(1) * F(n - 2) +...+ F(n - 1) * F(0) (n > 2)
     */
    public int numTrees(int n) {
        if (n <= 2) return n;
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
}
