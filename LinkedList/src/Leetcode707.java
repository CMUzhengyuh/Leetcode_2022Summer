/**
 * 05/29/2022
 */
public class Leetcode707 {
    /**
     * Leetcode 707 - Design Linked List (Easy)
     * Design the LinkedList class
     * *** Possible optimization:
     * (1) tail pointer (2) size field (3) doubly linked list
     */
    class MyLinkedList {
        /**
         * LinkedList Node Class
         */
        private class ListNode {

            private int val;

            private ListNode next;

            public ListNode() {}

            public ListNode(int val) { this.val = val; }

        }

        private ListNode head;

        public MyLinkedList() {
            head = null;
        }

        public int get(int index) {
            int res = -1, count = 0;
            ListNode cur = head;
            while (cur != null) {
                if (count == index) {
                    return cur.val;
                }
                count++;
                cur = cur.next;
            }
            return res;
        }

        public void addAtHead(int val) {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
        }

        public void addAtTail(int val) {
            if (head == null) {
                head = new ListNode(val);
                return;
            }
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            int count = 0;
            ListNode dummy = new ListNode(-1), cur = dummy;
            dummy.next = head;
            while (cur != null) {
                if (count == index) {
                    break;
                }
                System.out.println(cur.val);
                count++;
                cur = cur.next;
            }
            if (cur == null) return;
            ListNode newNode = new ListNode(val);
            newNode.next = cur.next;
            cur.next = newNode;
            head = dummy.next;
        }

        public void deleteAtIndex(int index) {
            ListNode dummy = new ListNode(-1), cur = dummy;
            dummy.next = head;
            int count = 0;
            while (cur != null) {
                if (count == index) {
                    break;
                }
                count++;
                cur = cur.next;
            }
            if (cur == null || cur.next == null) return;
            cur.next = cur.next.next;
            head = dummy.next;
        }
    }
}
