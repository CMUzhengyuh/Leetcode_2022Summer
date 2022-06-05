import java.util.ArrayList;
import java.util.List;
/**
 * 06/04/2022
 */
public class Leetcode94 {

    private List<Integer> list;

    /**
     * Leetcode 94 - Binary Tree Inorder Traversal (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursive traversal: left -> right -> parent.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    private void traverse(TreeNode cur) {
        if (cur == null) return;
        traverse(cur.left);
        list.add(cur.val);
        traverse(cur.right);
    }
}