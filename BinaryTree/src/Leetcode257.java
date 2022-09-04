import java.util.*;
/**
 * 06/10/2022
 */
public class Leetcode257 {

    private List<String> res;

    /**
     * Leetcode 257 - Binary Tree Paths (Easy)
     * TC: O(n)
     * SC: O(n)
     * Depth First Search for all possible paths:
     * (1) When reaching the leaf node, add the path string to list.
     * (2) Recursively explore left and right subtree if not null.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<String>();
        DFS(root, new ArrayList<Integer>());
        return res;
    }

    private void DFS(TreeNode cur, List<Integer> list) {
        if (cur.left == null && cur.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) {
                sb.append(i).append("->");
            }
            sb.append(cur.val);
            res.add(sb.toString());
            return;
        }
        list.add(cur.val);
        if (cur.left != null) {
            DFS(cur.left, list);
        }
        if (cur.right != null) {
            DFS(cur.right, list);
        }
        list.remove(list.size() - 1);
    }
}
