import java.util.*;
/**
 * 06/05/2022
 */
public class Leetcode107 {

    private List<List<Integer>> res;

    /**
     * Leetcode 107 - Binary Tree Level Order Traversal II (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) Depth first search the BST (create an empty list if needed).
     * (2) Record nodes of each level to corresponding lists.
     * (3) Reverse the overall result.
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        DFS(root, 0);
        Collections.reverse(res);
        return res;
    }

    private void DFS(TreeNode cur, int depth) {
        if (res.size() == depth) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(cur.val);
        if (cur.left != null) DFS(cur.left, depth + 1);
        if (cur.right != null) DFS(cur.right, depth + 1);
    }
}