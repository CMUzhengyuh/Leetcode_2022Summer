/**
 * 05/23/2022
 */
public class Leetcode876 {
    /**
     * Leetcode 876 - Middle of the Linked List (Easy)
     * TC: O(n)
     * SC: O(1)
     * Fast pointer moves 2 units at a time
     * Slow pointer moves 1 unit at a time
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
