/**
 * 06/08/2022
 */
public class Leetcode1008 {

    private int[] preorder;

    /**
     * Leetcode 1008 - Construct Binary Search Tree from Preorder Traversal (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) The root value is the leftmost value in current window.
     * (2) Find the position of right subtree root in the array.
     * (3) Construct left and right subtree recursively.
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        return BSTHelper(0, preorder.length - 1);
    }

    private TreeNode BSTHelper(int left, int right) {
        if (left > right) return null;
        int val = preorder[left], rightRoot;
        for (rightRoot = left; rightRoot <= right; rightRoot++) {
            if (preorder[rightRoot] > val) break;
        }
        TreeNode cur = new TreeNode(preorder[left]);
        cur.left = BSTHelper(left + 1, rightRoot - 1);
        cur.right = BSTHelper(rightRoot, right);
        return cur;
    }
}
