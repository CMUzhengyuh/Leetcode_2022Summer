import java.util.*;
/**
 * 09/03/2022
 */
public class Leetcode987 {

    public class Node {

        private TreeNode cur;

        private int row;

        private int col;

        public Node(TreeNode cur, int row, int col) {
            this.cur = cur;
            this.row = row;
            this.col = col;
        }
    }

    /**
     * Leetcode 987 - Vertical Order Traversal of a Binary Tree (Hard)
     * TC: O(nlogn)
     * SC: O(n)
     * Data structure:
     * (1) Node class to store the node in the tree and corresponding index.
     * (2) TreeMap to store the column index to value list mapping.
     * (3) PriorityQueue to aid breadth first search sorted by row then value.
     * Traverse the whole tree and keep updating the map with sorted value so
     * that the result can be directly derived by the value set of TreeMap.
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> (a.row == b.row ? a.cur.val - b.cur.val : a.row - b.row));
        q.add(new Node(root, 0, 0));
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                TreeNode cur = n.cur;
                int col = n.col;
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(cur.val);
                if (cur.left != null) {
                    q.add(new Node(cur.left, level, col - 1));
                }
                if (cur.right != null) {
                    q.add(new Node(cur.right, level, col + 1));
                }
            }
        }
        return new ArrayList<>(map.values());
    }
}
