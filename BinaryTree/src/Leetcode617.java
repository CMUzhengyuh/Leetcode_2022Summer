/**
 * 06/11/2022
 */
public class Leetcode617 {
    /**
     * Leetcode 617 - Merge Two Binary Trees (Easy)
     * TC: O(n)
     * SC: O(n)
     * Depth first search original trees and form a new binary tree:
     * (1) If both two nodes have values, form a new node and continue.
     * (2) Else, return the node that is not null (return null if neither).
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return DFS(root1, root2);
    }

    private TreeNode DFS(TreeNode cur1, TreeNode cur2) {
        if (cur1 == null && cur2 == null) return null;
        if (cur1 != null && cur2 == null) return cur1;
        if (cur1 == null && cur2 != null) return cur2;
        int val = cur1.val + cur2.val;
        TreeNode cur = new TreeNode(val);
        cur.left = DFS(cur1.left, cur2.left);
        cur.right = DFS(cur1.right, cur2.right);
        return cur;
    }
}
