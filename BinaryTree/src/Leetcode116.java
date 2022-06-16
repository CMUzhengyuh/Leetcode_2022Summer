import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 06/16/2022
 */
public class Leetcode116 {
    /**
     * Leetcode 116 - Populating Next Right Pointers in Each Node (Medium)
     * TC: O(n)
     * SC: O(n）
     * Breath first search the whole tree but traverse reversely in each level
     * so that the next pointer can be updated according through the process.
     */
    public Node connect(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        if (root == null) return root;
        q.addFirst(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node next = null;
            Node cur;
            for (int i = 0; i < size; i++) {
                cur = q.removeLast();
                cur.next = next;
                next = cur;
                if (cur.left != null) {
                    q.addFirst(cur.right);
                    q.addFirst(cur.left);
                }
            }
        }
        return root;
    }

    /**
     * Corner Case: EMPTY TREE
     */

    /**
     * N-ary Tree Node Class
     */
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
