/**
 * 06/15/2022
 */
public class Leetcode222 {
    /**
     * Leetcode 222 - Count Complete Tree Nodes (Medium)
     * TC: O(n)
     * SC: O(n）
     * The recursive version is quit straight-forward but not the optimal.
     * *** The optimal method adopts binary search rather than linear search.
     */
    public int countNodes(TreeNode root) {
        return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
    }
}
