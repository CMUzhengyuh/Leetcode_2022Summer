/**
 * 05/24/2022
 */
public class Leetcode82 {
    /**
     * Leetcode 82 - Remove Duplicates from Sorted List II (Medium)
     * TC: O(n)
     * SC: O(1)
     * Create dummy head node and auxiliary pointers: prev -> temp
     * One traversal for temp pointer and check the duplicates:
     * No duplicates - pointers move forward
     * Duplicates - remove nodes after prev that share the same value
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1), temp = head, prev = dummy;
        dummy.next = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                ListNode nextNode = temp.next;
                while (nextNode != null && nextNode.val == temp.val) {
                    nextNode = nextNode.next;
                }
                prev.next = nextNode;
                temp = nextNode;
            } else {
                temp = temp.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
