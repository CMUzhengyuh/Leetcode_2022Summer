import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * 06/16/2022
 */
public class Leetcode515 {
    /**
     * Leetcode 515 - Find Largest Value in Each Tree Row (Medium)
     * TC: O(n)
     * SC: O(n）
     * Breadth first search the whole tree and find out the maximum value.
     */
    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size(), max = q.peekFirst().val;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeFirst();
                if (cur.val > max) max = cur.val;
                if (cur.left != null) q.addLast(cur.left);
                if (cur.right != null) q.addLast(cur.right);
            }
            list.add(max);
        }
        return list;
    }

    /**
     * Corner Case: EMPTY TREE
     */
}
