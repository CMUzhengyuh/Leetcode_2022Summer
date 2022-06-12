/**
 * 06/12/2022
 */
public class Leetcode236 {
    /**
     * Leetcode 236 - Lowest Common Ancestor of a Binary Tree (Medium)
     * TC: O(n)
     * SC: O(n）
     * Recursively find the lowest common ancestor (LCA):
     * (1) If both nodes in binary tree in current node, then return their LCA.
     * (2) If neither node exists in binary tree in current node, return null.
     * (3) If only one locates in binary tree in current node, return the node.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }
}
