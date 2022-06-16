/**
 * 06/15/2022
 */
public class Leetcode129 {

    private int sum;

    /**
     * Leetcode 129 - Sum Root to Leaf Numbers (Medium)
     * TC: O(n)
     * SC: O(n）
     * Recursively add the value when a path reaches leaf node.
     */
    public int sumNumbers(TreeNode root) {
        sum = 0;
        DFS(root, 0);
        return sum;
    }

    private void DFS(TreeNode cur, int curSum) {
        curSum *= 10;
        curSum += cur.val;
        if (cur.left == null && cur.right == null) {
            sum += curSum;
            return;
        }
        if (cur.left != null) DFS(cur.left, curSum);
        if (cur.right != null) DFS(cur.right, curSum);
    }
}
