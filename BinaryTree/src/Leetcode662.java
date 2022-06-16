import java.util.ArrayList;
import java.util.List;
/**
 * 06/15/2022
 */
public class Leetcode662 {
    /**
     * Leetcode 662 - Maximum Width of Binary Tree (Medium)
     * TC: O(n)
     * SC: O(n）
     * Mark the index of node in each level with the following rule:
     * (1) root = 1 (2) left child = 2 * root, right child = 2 * root + 1
     * Recursively traverse for the width of current, left and right child.
     */
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return DFS(root, 1, 0, list);
    }

    private int DFS(TreeNode cur, int index, int level, List<Integer> lefts) {
        if (cur == null) {
            return 0;
        }
        if (level >= lefts.size()) {
            lefts.add(index);
        }
        int leftWidth = DFS(cur.left, index * 2, level + 1, lefts);
        int rightWidth = DFS(cur.left, index * 2 + 1, level + 1, lefts);
        int childMax = Math.max(leftWidth, rightWidth);
        return Math.max(index + 1 - lefts.get(level), childMax);
    }
}
