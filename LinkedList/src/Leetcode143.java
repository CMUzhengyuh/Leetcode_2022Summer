/**
 * 05/24/2022
 */
public class Leetcode143 {
    /**
     * Leetcode 143 - Reorder List (Medium)
     * TC: O(n)
     * SC: O(1)
     * (1) Find the middle point.
     * (2) Reverse the second half of the list.
     * (3) Merge two lists.
     */
    public void reorderList(ListNode head) {
        if (head == null) return;
        /**
         * Find the middle of linked list - Leetcode 876
         */
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /**
         * Reverse the second part - Leetcode 206
         */
        ListNode prev = null, cur = slow, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        /**
         * Merge two parts - Leetcode 21
         */
        ListNode first = head, second = prev;
        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }

    /**
     * Corner Case: []
     */
}
