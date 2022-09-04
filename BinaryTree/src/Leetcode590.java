import java.util.*;
/**
 * 06/04/2022
 */
public class Leetcode590 {

    private List<Integer> list;

    /**
     * Leetcode 590 - N-ary Tree Postorder Traversal (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursive traversal: children (if any) -> parent.
     */
    public List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    private void traverse(Node cur) {
        if (cur == null) return;

        for (Node n : cur.children) {
            traverse(n);
        }
        list.add(cur.val);
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