/**
 * 05/25/2022
 */
public class Leetcode147 {
    /**
     * Leetcode 147 - Insertion Sort List (Medium)
     * TC: O(n^2)
     * SC: O(1)
     * InsertionSort in a linked list version.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1), tail = head;
        dummy.next = head;
        while (tail != null && tail.next != null) {
            ListNode temp = tail.next, cur = dummy;
            while (cur != null && cur.next != null && cur != tail) {
                if (cur.next.val > temp.val) break;
                cur = cur.next;
            }
            if (cur != tail) {
                tail.next = temp.next;
                temp.next = cur.next;
                cur.next = temp;
            } else {
                tail = tail.next;
            }
        }
        return dummy.next;
    }
}
