import java.util.ArrayList;
import java.util.List;
/**
 * 06/04/2022
 */
public class Leetcode589 {

    private List<Integer> list;

    /**
     * Leetcode 589 - N-ary Tree Preorder Traversal (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursive traversal: parent -> children (if any).
     */
    public List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    private void traverse(Node cur) {
        if (cur == null) return;
        list.add(cur.val);
        for (Node n : cur.children) {
            traverse(n);
        }

    }

    /**
     * N-ary Tree Node Class
     */
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}