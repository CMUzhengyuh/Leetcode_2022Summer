import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 06/11/2022
 */
public class Leetcode111 {
    /**
     * Leetcode 111 - Minimum Depth of Binary Tree (Easy)
     * TC: O(n)
     * SC: O(n）
     * Breadth first search for the first tree node and return the depth.
     */
    public int minDepth(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        if (root == null) return depth;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pollFirst();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) queue.addLast(cur.left);
                if (cur.right != null) queue.addLast(cur.right);
            }
        }
        return -1;
    }

    /**
     * Corner Case: EMPTY TREE
     */
}
