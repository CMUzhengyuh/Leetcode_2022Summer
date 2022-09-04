import java.util.*;
/**
 * 05/22/2022
 */
public class Leetcode234 {
    /**
     * Leetcode 234 - Palindrome Linked List (Easy)
     * TC: O(n)
     * SC: O(n)
     * Fast pointer moves 2 units at a time until the end
     * Slow pointer moves 1 unit at a time and push value to stack.
     * Adjust the slow pointer to the start point of right part.
     * Check the equality of corresponding elements.
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.push(slow.val);
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
