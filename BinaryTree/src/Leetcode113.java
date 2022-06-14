import java.util.ArrayList;
import java.util.List;
/**
 * 06/13/2022
 */
public class Leetcode113 {

    private List<List<Integer>> res;

    /**
     * Leetcode 113 - Path Sum II (Medium)
     * TC: O(n)
     * SC: O(n）
     * Record each root-to-leaf path as a list and verify the sum in the leaf.
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if (root == null) return res;
        DFS(root, new ArrayList<>(), targetSum);
        return res;
    }

    private void DFS(TreeNode cur, List<Integer> list, int target) {
        if (cur.left == null && cur.right == null) {
            if (cur.val == target) {
                list.add(cur.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(cur.val);
        if (cur.left != null) {
            DFS(cur.left, list, target - cur.val);
        }
        if (cur.right != null) {
            DFS(cur.right, list, target - cur.val);
        }
        list.remove(list.size() - 1);
    }

    /**
     * Corner Case: EMPTY TREE
     */
}
