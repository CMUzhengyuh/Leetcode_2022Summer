import java.util.ArrayList;
import java.util.List;
/**
 * 06/04/2022
 */
public class Leetcode145 {

    private List<Integer> list;

    /**
     * Leetcode 145 - Binary Tree Postorder Traversal (Easy)
     * TC: O(n)
     * SC: O(1)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    private void traverse(TreeNode cur) {
        if (cur == null) return;
        traverse(cur.left);
        traverse(cur.right);
        list.add(cur.val);
    }
}
