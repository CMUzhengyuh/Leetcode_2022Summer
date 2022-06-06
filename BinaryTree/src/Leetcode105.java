/**
 * 06/06/2022
 */
public class Leetcode105 {

    private int[] preorder, inorder;

    /**
     * Leetcode 105 - Construct Binary Tree from Preorder and Inorder Traversal (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) Find the root according to inorder and preorder result.
     * (2) Construct left subtree:
     *     Inorder array starts at left and ends at mid - 1.
     *     Preorder array starts at (index + 1) because the root of left subtree
     *     lies in the next of the parent node.
     * (3) Construct right subtree:
     *     Inorder array starts at mid + 1 and ends at right.
     *     Preorder array starts at (index + leftSize + 1) because the root of
     *     right subtree lies in (leftSize + 1) after the parent node while here
     *     leftSize = mid - left.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return BSTHelper(0, inorder.length - 1, 0);
    }

    /**
     * @param left  left index of inorder
     * @param right right index of inorder
     * @param index index of root in preorder
     */
    private TreeNode BSTHelper(int left, int right, int index) {
        if (right < left) return null;
        int mid = left;
        for (mid = left; mid <= right; mid++) {
            if (inorder[mid] == preorder[index]) {
                break;
            }
        }
        TreeNode cur = new TreeNode(inorder[mid]);
        cur.left = BSTHelper(left, mid - 1, index + 1);
        cur.right = BSTHelper(mid + 1, right, index - left + mid + 1);
        return cur;
    }
}
