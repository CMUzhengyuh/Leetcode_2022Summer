/**
 * 06/11/2022
 */
public class Leetcode112 {
    /**
     * Leetcode 112 - Path Sum (Easy)
     * TC: O(n)
     * SC: O(n）
     * Verify very possible leaf node for possible answers.
     * What is worth mentioning that only root node cannot form a path.
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * Corner Case: EMPTY TREE
     * Corner Case: PATH WITH ONLY ROOT NODE
     */
}
