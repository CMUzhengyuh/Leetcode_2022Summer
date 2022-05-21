/**
 * 05/21/2022
 */
public class Leetcode83 {
    /**
     * Leetcode 83 - Remove Duplicates from Sorted List (Easy)
     * TC: O(n)
     * SC: O(1)
     * One traversal, delete all possible duplicates for current val.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * Corner Case: []
     */
}
