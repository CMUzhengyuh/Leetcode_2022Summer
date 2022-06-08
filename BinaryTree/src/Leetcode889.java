/**
 * 06/07/2022
 */
public class Leetcode889 {

    private int[] pre, post;

    /**
     * Leetcode 889 - Construct Binary Tree from Preorder and Postorder Traversal (Medium)
     * TC: O(n)
     * SC: O(n)
     * The idea is the same with Leetcode 105 & 106 but implementation differs:
     * (1) The parent node position is easy to find preorder[preLeft].
     * (2) Find the root of left subtree in preorder array for leftSize.
     * (3) Update the index in next recursion:
     * (i) Left subtree: preorder[preLeft + 1, preLeft + 1 + leftSize]
     *                   postorder[postLeft, postleft + leftSize]
     * (ii) Right subtree: preorder[preLeft + 1 + leftSize + 1, preRight]
     *                     postorder[postleft + leftSize + 1, postRight - 1]
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.pre = preorder;
        this.post = postorder;
        return BSTHelper(0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode BSTHelper(int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight || postLeft > postRight) return null;
        if (preLeft == preRight) { return new TreeNode(pre[preLeft]); }
        int preRoot = preLeft + 1, postRoot = postLeft;
        for (postRoot = postLeft; postRoot <= postRight; postRoot++) {
            if (post[postRoot] == pre[preRoot]) {
                break;
            }
        }
        int leftSize = postRoot - postLeft;
        int rightSize = postRight - postLeft - leftSize - 1;
        TreeNode cur = new TreeNode(pre[preLeft]);
        cur.left = BSTHelper(preLeft + 1, preLeft + leftSize + 1, postLeft, postLeft + leftSize);
        cur.right = BSTHelper(preRight - rightSize + 1, preRight, postRight - rightSize, postRight - 1);
        return cur;
    }
}
