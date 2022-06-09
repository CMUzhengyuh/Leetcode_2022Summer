/**
 * 06/09/2022
 */
public class Leetcode226 {
    /**
     * Leetcode 226 - Invert Binary Tree (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursively swift left and right subtree for each nodes.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}
