/**
 * 05/24/2022
 */
public class Leetcode19 {
    /**
     * Leetcode 19 - Remove Nth Node From End of List (Medium)
     * TC: O(n)
     * SC: O(1)
     * Create dummy head node and auxiliary pointers:
     * Fast pointer moves (n + 1) steps faster than slow pointer.
     * Traverse the list until fast pointer reach the end.
     * The next node of slow pointer is the node to move.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1), fast = dummy, slow = dummy;
        dummy.next = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
