/**
 * 06/01/2022
 */
public class Leetcode21 {
    /**
     * Leetcode 21 - Merge Two Sorted Lists (Easy)
     * TC: O(m + n)
     * SC: O(n + m)
     * Add remaining part of another list to the tail when one reached the end.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1), p1 = list1, p2 = list2, cur = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                cur.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) cur.next = p1;
        else cur.next = p2;
        return head.next;
    }
}
