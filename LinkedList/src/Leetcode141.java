/**
 * 05/19/2022
 */
public class Leetcode141 {
    /**
     * Leetcode 141 - Linked List Cycle (Easy)
     * TC: O(n)
     * SC: O(1)
     * Floyd's Cycle Finding Algorithm
     * Fast pointer moves 2 units at a time
     * Slow pointer moves 1 unit at a time
     * Two pointer meet -> hasCycle = true
     * Fast pointer reach tail -> hasCycle = false
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
