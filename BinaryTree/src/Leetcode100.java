/**
 * 06/11/2022
 */
public class Leetcode100 {
    /**
     * Leetcode 100 - Same Tree (Easy)
     * TC: O(n)
     * SC: O(n)
     * Same tree recursive definition:
     * Same values + left subtree (if any) + right subtree (if any).
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
