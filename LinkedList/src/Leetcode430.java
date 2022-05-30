/**
 * 05/29/2022
 */
public class Leetcode430 {

    private Node tail = null;

    /**
     * Leetcode 430 - Flatten a Multilevel Doubly Linked List (Medium)
     * TC: O(n)
     * SC: O(n)
     * Recursively flatten the list level by level.
     */
    public Node flatten(Node head) {
        if (head == null) return null;
        head.prev = tail;
        tail = head;
        Node nextNode = head.next;
        head.next = flatten(head.child);
        head.child = null;
        tail.next = flatten(nextNode);
        return head;
    }

    /**
     * Doubly LinkedList node with child pointer
     */
    public class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
