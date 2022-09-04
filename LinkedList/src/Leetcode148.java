import java.util.*;
/**
 * 05/25/2022
 */
public class Leetcode148 {
    /**
     * Leetcode 19 - Remove Nth Node From End of List (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * *** Optimal solution is mergeSort or quickSort with SC: O(1)
     * Use priority queue to store each node value.
     */
    public ListNode sortList(ListNode head) {
        ListNode curr = head;
        Queue<Integer> queue = new PriorityQueue<>();
        while (curr != null) {
            queue.add(curr.val);
            curr = curr.next;
        }
        ListNode dummy = new ListNode();
        curr = dummy;
        while (!queue.isEmpty()) {
            curr.next = new ListNode(queue.poll());
            curr = curr.next;
        }
        return dummy.next;
    }
}
