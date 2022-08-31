import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * Leetcode 742.
 */
public class _Closest_Leaf_In_Binary_Tree_ {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Map to store the child -> parent relationships.
     */
    private Map<TreeNode, TreeNode> map = new HashMap<>();

    public int findClosestLeaf(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        // Set to store visited TreeNodes during the BFS.
        Set<TreeNode> visited = new HashSet<>();

        TreeNode node = DFS(root, k);
        q.add(node);
        visited.add(node);

        // Breadth first search until the leaf node.
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left == null && cur.right == null) {
                return cur.val;
            }
            // Search in three directions: left, right and up.
            if (cur.left != null && !visited.contains(cur.left)) {
                q.add(cur.left);
                visited.add(cur.left);
            }
            if (cur.right != null && !visited.contains(cur.right)) {
                q.add(cur.right);
                visited.add(cur.right);
            }
            if (map.containsKey(cur) && !visited.contains(map.get(cur))) {
                q.add(map.get(cur));
                visited.add(map.get(cur));
            }
        }
        return -1;
    }

    /**
     * Depth first search helper function to find given node and update map.
     */
    private TreeNode DFS(TreeNode cur, int k) {
        if (cur.val == k) {
            return cur;
        }
        if (cur.left != null) {
            map.put(cur.left, cur);
            TreeNode left = DFS(cur.left, k);
            if (left != null) return left;
        }
        if (cur.right != null) {
            map.put(cur.right, cur);
            TreeNode right = DFS(cur.right, k);
            if (right != null) return right;
        }
        return null;
    }
}