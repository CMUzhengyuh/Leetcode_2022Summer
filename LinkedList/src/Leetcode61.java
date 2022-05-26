/**
 * 05/25/2022
 */
public class Leetcode61 {
    /**
     * Leetcode 61 - Rotate List (Medium)
     * TC: O(n)
     * SC: O(1)
     * Count the number of nodes and find out the tail position.
     * Truncate rotation times with (mod size) to avoid redundancy.
     * (1) Form a cycle first
     * (2) Move tail pointer (size - k) times
     * (3) Break the cycle and return the new head
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        k = k % size;
        tail.next = head;
        while (k++ < size) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }

    /**
     * Corner Case: []
     * Corner Case: ONLY ONE NODE
     */
}
