/**
 * 06/06/2022
 */
public class Leetcode106 {

    private int[] postorder, inorder;

    /**
     * Leetcode 106 - Construct Binary Tree from Inorder and Postorder Traversal (Medium)
     * TC: O(n)
     * SC: O(n)
     * Share similar code with Leetcode 105.
     * Tricky point is the postorder array index of left subtree.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        return BSTHelper(0, inorder.length - 1, inorder.length - 1);
    }

    /**
     * @param left  left index of inorder
     * @param right right index of inorder
     * @param index index of root in postorder
     */
    private TreeNode BSTHelper(int left, int right, int index) {
        if (right < left) return null;
        int mid = left;
        for (mid = left; mid <= right; mid++) {
            if (inorder[mid] == postorder[index]) {
                break;
            }
        }
        TreeNode cur = new TreeNode(inorder[mid]);
        cur.left = BSTHelper(left, mid - 1, index - (right - mid) - 1);
        cur.right = BSTHelper(mid + 1, right, index - 1);
        return cur;
    }
}
