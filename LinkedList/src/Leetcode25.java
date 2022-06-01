/**
 * 05/31/2022
 */
public class Leetcode25 {
    /**
     * Leetcode 25 - Reverse Nodes in k-Group (Hard)
     * TC: O(n)
     * SC: O(1)
     * (1) Count the number of nodes and calculate how many groups to reverse.
     * (2) For each group:
     * (i) Find the tail node.
     * (ii) Remove the node after cur and insert it after tail for k times.
     * (iii) Reset the cur pointer.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode dummy = new ListNode(-1), cur = dummy;
        dummy.next = head;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        int size = count / k;
        cur = dummy;
        count = 0;
        for (int i = 0; i < size; i++) {
            ListNode tail = cur;
            while (count < k) {
                tail = tail.next;
                count++;
            }
            while (cur.next != tail) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }
            while (count > 0) {
                cur = cur.next;
                count--;
            }
        }
        return dummy.next;
    }
}
