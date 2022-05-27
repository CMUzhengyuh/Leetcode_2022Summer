import java.util.HashMap;
import java.util.Map;
/**
 * 05/26/2022
 */
public class Leetcode138 {
    /**
     * Leetcode 138 - Copy List with Random Pointer (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) Copy the main link and record the oldNode to newNode mapping.
     * (2) Traverse from the head again and complete the random link.
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node newHead = new Node(-1), cur = head, temp = newHead;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            temp.next = new Node(cur.val);
            temp = temp.next;
            map.put(cur, temp);
            cur = cur.next;
        }
        temp = newHead.next;
        cur = head;
        while (temp != null) {
            if (cur.random != null) {
                temp.random = map.get(cur.random);
            }
            temp = temp.next;
            cur = cur.next;
        }
        return newHead.next;
    }

    /**
     * Corner Case: []
     * Corner Case: ONLY ONE NODE
     */

    /**
     * Multi-link Node Class
     */
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
