/**
 * 06/02/2022
 */
public class Leetcode1669 {
    /**
     * Leetcode 1669 - Merge In Between Linked Lists (Medium)
     * TC: O(m + n)
     * SC: O(1)
     * Change next pointer in two places:
     * (1) (a - 1)-index node in list1 -> head node of list2.
     * (2) Tail node in list2 -> (b + 1)-index node in list1.
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1), cur = dummy, tail = list2;
        dummy.next = list1;
        int count = 0;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (count <= b) {
            if (count == a) {
                ListNode temp = cur.next;
                cur.next = list2;
                count++;
                cur = temp;
                continue;
            }
            count++;
            cur = cur.next;
        }
        tail.next = cur.next;
        return dummy.next;
    }
}
