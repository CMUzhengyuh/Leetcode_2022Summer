import java.util.*;
/**
 * 06/02/2022
 */
public class Leetcode445 {
    /**
     * Leetcode 445 - Add Two Numbers II (Medium)
     * TC: O(max(m, n))
     * SC: O(max(m, n))
     * Use two stacks instead of two pointers.
     * Calculate lower digits before higher digits and addFirst to result list.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        ListNode cur1 = l1, cur2 = l2, head = new ListNode(-1);
        while (cur1 != null) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }
        int res = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || res != 0) {
            if (!stack1.isEmpty()) {
                res += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                res += stack2.pop();
            }
            ListNode digit = new ListNode(res % 10);
            digit.next = head.next;
            head.next = digit;
            res /= 10;
        }
        return head.next;
    }
}
