import java.util.PriorityQueue;
/**
 * 06/03/2022
 */
public class Leetcode23 {
    /**
     * Leetcode 23 - Merge k Sorted Lists (Hard)
     * TC: O(nlogn)
     * SC: O(n)
     * Add all nodes to the PriorityQueue and pop out to create the new list.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode dummy = new ListNode(-1), cur = dummy;
        for (ListNode list : lists) {
            while (list != null) {
                pq.add(list);
                list = list.next;
            }
        }
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            cur.next = null;
        }
        return dummy.next;
    }
}
