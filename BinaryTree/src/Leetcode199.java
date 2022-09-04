import java.util.*;
/**
 * 06/16/2022
 */
public class Leetcode199 {
    /**
     * Leetcode 199 - Binary Tree Right Side View (Medium)
     * TC: O(n)
     * SC: O(n）
     * Breadth first search the whole tree and record the rightmost value.
     */
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeFirst();
                if (cur.left != null) q.addLast(cur.left);
                if (cur.right != null) q.addLast(cur.right);
                if (i == size - 1) list.add(cur.val);
            }
        }
        return list;
    }

    /**
     * Corner Case: EMPTY TREE
     */
}
