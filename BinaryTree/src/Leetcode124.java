/**
 * 06/16/2022
 */
public class Leetcode124 {

    private int res = Integer.MIN_VALUE;

    /**
     * Leetcode 124 - Binary Tree Maximum Path Sum (Hard)
     * TC: O(n)
     * SC: O(n）
     * Depth first search the whole tree with recursive functions:
     * (1) When reach the null, return 0.
     * (2) Calculate the left and right path sum if exists.
     * (3) Update the (leftMax + cur + rightMax) result (possible new maximum).
     * (4) The return value reflects maximum sum through current node.
     */
    public int maxPathSum(TreeNode root) {
        DFS(root);
        return res;
    }

    private int DFS(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int left = DFS(cur.left), right = DFS(cur.right);
        if (left < 0) { left = 0; }
        if (right < 0) { right = 0; }
        res = Math.max(res, left + right + cur.val);
        int max = Math.max(left, right);
        return (max > 0 ? max : 0) + cur.val;

    }
}
