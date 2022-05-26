/**
 * 05/25/2022
 */
public class Leetcode142 {
    /**
     * Leetcode 142 - Linked List Cycle II (Easy)
     * TC: O(n)
     * SC: O(1)
     * Judge whether a cycle occurs in the given list:
     * Fast pointer moves 2 units at a time
     * Slow pointer moves 1 unit at a time
     * If two pointers meet before reaching the end, then a cycle occurs.
     * Move the fast node back to starting point and move 1 unit at a time.
     * Two pointer meet at where the cycle begins.
     * O --------------- A --------- B ---------------
     *          a              b              c
     * First meet: (a + b) : (a + b + c + b) = 1 : 2 -> a = c
     * Fast pointer return to starting point:
     * Fast move a and slow move c to reach the cycle starting point A
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast.next == null || fast.next.next == null) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
