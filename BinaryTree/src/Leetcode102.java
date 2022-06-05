import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * 06/05/2022
 */
public class Leetcode102 {
    /**
     * Leetcode 102 - Binary Tree Level Order Traversal (Medium)
     * TC: O(n)
     * SC: O(n)
     * Breadth first search the BST and record nodes of each level.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return res;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                list.add(cur.val);
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
            }
            res.add(list);
        }
        return res;
    }

    /**
     * Corner Case: EMPTY TREE
     */
}
