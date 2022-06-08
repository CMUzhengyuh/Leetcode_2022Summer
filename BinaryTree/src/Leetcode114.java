/**
 * 06/07/2022
 */
public class Leetcode114 {
    /**
     * Leetcode 114 - Flatten Binary Tree to Linked List (Medium)
     * TC: O(n)
     * SC: O(logn)
     * For each node that has non-empty left subtree:
     * (1) Find the rightmost node of left subtree.
     * (2) Set right subtree to right pointer of left subtree's rightmost node.
     * (3) Set left subtree to right pointer of current node.
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
