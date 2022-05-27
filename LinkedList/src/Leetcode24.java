/**
 * 05/26/2022
 */
public class Leetcode24 {
    /**
     * Leetcode 24 - Swap Nodes in Pairs (Medium)
     * TC: O(n)
     * SC: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        dummy.next = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = temp.next;
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
