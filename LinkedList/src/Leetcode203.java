/**
 * 05/23/2022
 */
public class Leetcode203 {
    /**
     * Leetcode 203 -  Remove Linked List Elements (Easy)
     * TC: O(n)
     * SC: O(1)
     * Create a dummy head node.
     * Remove next node(s) for current position that match the value.
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(), cur = dummy;
        dummy.next = head;
        while (cur != null && cur.next != null) {
            while ( cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
