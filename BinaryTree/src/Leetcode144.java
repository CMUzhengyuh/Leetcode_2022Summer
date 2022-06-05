import java.util.ArrayList;
import java.util.List;
/**
 * 06/04/2022
 */
public class Leetcode144 {

    private List<Integer> list;

    /**
     * Leetcode 144 - Binary Tree Preorder Traversal (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursive traversal: parent -> left -> right.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    private void traverse(TreeNode cur) {
        if (cur == null) return;
        list.add(cur.val);
        traverse(cur.left);
        traverse(cur.right);
    }
}