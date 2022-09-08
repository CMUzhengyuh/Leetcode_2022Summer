/**
 * 09/07/2022
 */
public class Leetcode337 {
    /**
     * Leetcode 337 - House Robber III (Medium)
     * TC: O(n)
     * SC: O(n)
     * 1D Dynamic Programming with fixed array length = 2:
     * dp[0] for each nodes records the maximum profit for current node but not
     * rob the current node, while dp[1] records profit that rob current one.
     * Pass the array through the DFS function from all possible paths to root.
     */
    public int rob(TreeNode root) {
        int[] res = DFS(root);
        return Math.max(res[0], res[1]);
    }

    private int[] DFS(TreeNode cur) {
        if (cur == null) {
            return new int[2];
        }
        int[] dp = new int[2];
        int[] left = new int[2];
        int[] right = new int[2];
        if (cur.left != null) {
            left = DFS(cur.left);
        }
        if (cur.right != null) {
            right = DFS(cur.right);
        }
        dp[1] = cur.val + left[0] + right[0];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return dp;
    }
}
