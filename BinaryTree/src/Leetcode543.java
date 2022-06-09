/**
 * 06/09/2022
 */
public class Leetcode543 {

    private int longestPath = 0;

    /**
     * Leetcode 543 - Diameter of Binary Tree (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursively update a global variable that records the longest length.
     * For each node in the tree:
     * (1) The longest path under current root is the longest path of left
     *     subtree going through root to the longest path of right subtree.
     * (2) Return the maximum of left and right subtree longest path plus 1
     *     (add current node) to pass the information from bottom to up.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameterHelper(root);
        return longestPath;
    }

    private int diameterHelper(TreeNode root) {
        if (root == null) return 0;
        int leftPath = diameterHelper(root.left);
        int rightPath = diameterHelper(root.right);
        longestPath = Math.max(leftPath + rightPath, longestPath);
        return Math.max(leftPath, rightPath) + 1;
    }
}
