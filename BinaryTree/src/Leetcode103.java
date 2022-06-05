import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Collections;
/**
 * 06/05/2022
 */
public class Leetcode103 {
    /**
     * Leetcode 103 - Binary Tree Zigzag Level Order Traversal (Medium)
     * TC: O(n)
     * SC: O(n)
     * Zigzag level order = level order + reverse lists in odd-index levels.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;
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
            if (!flag) {
                Collections.reverse(list);
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
