/**
 * 06/09/2022
 */
public class Leetcode104 {
    /**
     * Leetcode 104 - Maximum Depth of Binary Tree (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursively get the depth of every node from bottom to up.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
