/**
 * 06/01/2022
 */
public class Leetcode160 {
    /**
     * Leetcode 160 - Intersection of Two Linked Lists (Easy)
     * TC: O(n)
     * SC: O(1)
     * Two pointers start at two heads and move towards the tail.
     * When reaching the tail, start over at another tail.
     * Intersection lists will make two pointers encounter.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA, cur2 = headB;
        int flag = 0;
        while (cur1 != cur2) {
            if (cur1 == null) {
                cur1 = headB;
                flag++;
            } else cur1 = cur1.next;
            if (cur2 == null) {
                cur2 = headA;
                flag++;
            } else cur2 = cur2.next;
            if (flag > 2) return null;
        }
        return cur1;
    }

    /**
     * Corner Case: NO INTERSECTION
     */
}
