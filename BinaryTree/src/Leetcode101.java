/**
 * 06/09/2022
 */
public class Leetcode101 {
    /**
     * Leetcode 101 - Symmetric Tree (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursively compare every pair of nodes across the whole tree:
     * (1) Left subtree of node1 and right subtree of node2 is symmetric.
     * (2) Right subtree of node1 and left subtree of node2 is symmetric.
     * (3) Parent nodes share the same value.
     */
    public boolean isSymmetric(TreeNode root) {
        return compareNode(root, root);
    }

    private boolean compareNode(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && compareNode(n1.left, n2.right) && compareNode(n1.right, n2.left);
    }
}
