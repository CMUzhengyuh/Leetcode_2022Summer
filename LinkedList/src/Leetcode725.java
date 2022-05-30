/**
 * 05/29/2022
 */
public class Leetcode725 {
    /**
     * Leetcode 725 - Split Linked List in Parts (Medium)
     * TC: O(n + k)
     * SC: O(max(n, k))
     * (1) Count the total number of nodes of given list.
     * (2) Calculate the size and index of each sub-lists accordingly:
     *     i < index has (size + 1)) nodes and i > index has size nodes
     * (3) Create each sub-list and set the next pointer of tail node to null.
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] list = new ListNode[k];
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        int size = count / k, index = count % k;
        cur = head;
        for (int i = 0; i < k; i++) {
            list[i] = cur;
            count = 1;
            while (cur != null && count < (i < index ? size + 1 : size)) {
                cur = cur.next;
                count++;
            }
            if (cur != null) {
                ListNode newNode =  cur.next;
                cur.next = null;
                cur = newNode;
            }
        }
        return list;
    }
}
