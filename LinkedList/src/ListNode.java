/**
 * LinkedList Node Class
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode temp = this;
        while (temp != null) {
            str.append(temp.val);
            if (temp.next != null) {
                str.append("->");
            }
            temp = temp.next;
        }
        return str.toString();
    }
}
