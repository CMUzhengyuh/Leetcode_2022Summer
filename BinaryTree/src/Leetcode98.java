/**
 * 06/08/2022
 */
public class Leetcode98 {

    private boolean flag = true;

    /**
     * Leetcode 98 - Validate Binary Search Tree (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) Recursively pass the value boundary information from bottom to up.
     * (2) If any node doesn't satisfy conditions, the whole tree isn't a BST.
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        BSTHelper(root);
        return flag;
    }

    private int[] BSTHelper(TreeNode cur) {
        int[] res = new int[]{cur.val, cur.val};
        if (cur.left != null) {
            int[] leftBound = BSTHelper(cur.left);
            if (leftBound[1] >= cur.val) flag = false;
            res[0] = leftBound[0];
        }
        if (cur.right != null) {
            int[] rightBound = BSTHelper(cur.right);
            if (rightBound[0] <= cur.val) flag = false;
            res[1] = rightBound[1];
        }
        return res;
    }
}
