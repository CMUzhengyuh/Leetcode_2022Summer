/**
 * 06/10/2022
 */
public class Leetcode110 {

    private boolean flag = true;

    /**
     * Leetcode 110 - Balanced Binary Tree (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursively check if every node can serve as root of a balanced tree:
     * (1) Pass the height of current node from bottom to up.
     * (2) Set the flag to false if |Height(cur.left) - Height(cur.right)| > 1.
     */
    public boolean isBalanced(TreeNode root) {
        BalanceHelper(root);
        return flag;
    }

    private int BalanceHelper(TreeNode cur) {
        if (cur == null) return 0;
        int leftHeight = BalanceHelper(cur.left), rightHeight = BalanceHelper(cur.right);
        if (leftHeight < rightHeight - 1 || leftHeight > rightHeight + 1) flag = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
