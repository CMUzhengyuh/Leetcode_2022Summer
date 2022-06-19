/**
 * 06/18/2022
 */
public class Leetcode99 {

    private TreeNode prev = null, first = null, second = null;

    /**
     * Leetcode 99 - Recover Binary Search Tree (Medium)
     * TC: O(n)
     * SC: O(n)
     * Inorder traverse the whole tree and record two nodes that need to swap.
     */
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode cur) {
        if (cur == null)
            return;
        inorder(cur.left);
        if (prev != null && prev.val > cur.val) {
            if (first == null)
                first = prev;
            second = cur;
        }
        prev = cur;
        inorder(cur.right);
    }
}
