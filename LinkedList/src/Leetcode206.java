/**
 * 05/19/2022
 */
public class Leetcode206 {
    /**
     * Leetcode 206 - Reverse Linked List (Easy)
     * TC: O(n)
     * SC: O(1)
     * (1) Save the pointer of newHead node
     * (2) Add oldHead right after tail node
     * (3) Move forward head pointer
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode tail = head, cur = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        cur = tail;
        while (head != tail) {
            ListNode newHead = head.next;
            head.next = cur.next;
            cur.next = head;
            head = newHead;
        }
        return tail;
    }

    /**
     * Corner Case: []
     */
}
