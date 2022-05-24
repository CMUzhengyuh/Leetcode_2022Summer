/**
 * 05/23/2022
 */
public class Leetcode237 {
    /**
     * Leetcode 237 - Delete Node in a Linked List (Easy)
     * TC: O(1)
     * SC: O(1)
     * Copy the value of next node and delete it.
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
