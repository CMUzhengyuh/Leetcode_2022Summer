/**
 * 05/23/2022
 */
public class Leetcode92 {
    /**
     * Leetcode 92 - Reverse Linked List II (Medium)
     * TC: O(n)
     * SC: O(1)
     * leftNode - the node before left position
     * rightNode - the node in the right position
     * Reverse nodes between two position like Leetcode 206.
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(), cur = dummy, leftNode = null, rightNode = null;
        dummy.next = head;
        int step = 1;
        while (cur.next != null) {
            if (step == left) { leftNode = cur; }
            if (step == right) { rightNode = cur.next; }
            cur = cur.next;
            step++;
        }
        while (leftNode.next != rightNode) {
            ListNode move = leftNode.next;
            leftNode.next = move.next;
            move.next = rightNode.next;
            rightNode.next = move;
        }
        return dummy.next;
    }
}
