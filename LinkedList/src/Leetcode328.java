/**
 * 05/26/2022
 */
public class Leetcode328 {
    /**
     * Leetcode 328 - Odd Even Linked List (Medium)
     * TC: O(n)
     * SC: O(1)
     * Build the odd and even list separately and connect.
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head ;
        ListNode odd = head, even = head.next, temp = head.next ;
        while (even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = temp ;
        return head ;
    }
}
