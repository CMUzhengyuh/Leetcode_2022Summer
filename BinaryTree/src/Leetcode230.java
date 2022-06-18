/**
 * 06/17/2022
 */
public class Leetcode230 {

    private int count = 0;

    private int res = 0;

    /**
     * Leetcode 230 - Kth Smallest Element in a BST (Medium)
     * TC: O(n)
     * SC: O(n）
     * Inorder traverse to update the k-th smallest value.
     * *** Follow-up question: BST often modified?
     * *** Possible solution: record rank statistics.
     */
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return res;
    }

    private void traverse(TreeNode cur) {
        if (cur == null) return;
        traverse(cur.left);
        count--;
        if (count == 0) res = cur.val;
        traverse(cur.right);
    }
}
