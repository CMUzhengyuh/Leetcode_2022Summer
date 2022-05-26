/**
 * 05/25/2022
 */
public class Leetcode86 {
    /**
     * Leetcode 86 - Partition List (Medium)
     * TC: O(n)
     * SC: O(1)
     * Separate nodes whose value less and not less than x into two lists.
     * One traversal and reconnect two sub-lists.
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode slow = new ListNode(0);
        ListNode slowptr = slow;
        ListNode fast = new ListNode(0);
        ListNode fastptr = fast;
        while (head != null) {
            if (head.val < x) {
                slowptr.next = new ListNode(head.val);
                slowptr = slowptr.next;
            } else {
                fastptr.next = new ListNode(head.val);
                fastptr = fastptr.next;
            }
            head = head.next;
        }
        slowptr.next = fast.next;
        return slow.next;
    }
}
