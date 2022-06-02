/**
 * 06/01/2022
 */
public class Leetcode2 {
    /**
     * Leetcode 2 - Add Two Numbers (Medium)
     * TC: O(max(m, n))
     * SC: O(max(m, n))
     * Two pointers start at low digits and move towards high.
     * Calculate carry digit and current digit each time.
     * Add one more digit for the highest carry digit if needed.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1), p1 = l1, p2 = l2, cur = l;
        int carry = 0;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            carry /= 10;
        }
        if (carry != 0) cur.next = new ListNode(carry);
        return l.next;
    }

    /**
     * Corner Case: CARRY != 0 WHEN LISTS REACH THE END
     */
}
