import java.util.*;
/**
 * 09/21/2022
 */
public class Leetcode146 {
    /**
     * Leetcode 146 - LRU Cache (Medium)
     * The overall idea is to utilize a HashMap and doubly linked list.
     * The HashMap stores the key -> ListNode mapping while the linked list
     * stores the sequence of cache items. The APIs we need to use in the
     * linked list manipulations are addFirst() and remove().
     * (1) Get(): try to find the node with given key. Update the position of
     *     corresponding to the first after head to tag it 'recently used'.
     * (2) Put(): try to put a new key - value pair into the cache. When the
     *     new key doesn't exist in the underlying map, we need to add it to
     *     the linked list and hence possibly cause the size exceeds capacity.
     *     In this situation, we need to evict the last node.
     */
    class LRUCache {

        private ListNode head;

        private ListNode tail;

        private Map<Integer, ListNode> cache = new HashMap<>();

        private int size;

        private int capacity;

        private void addFirst(ListNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void remove(ListNode node) {
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        public LRUCache(int capacity) {
            this.head = new ListNode();
            this.tail = new ListNode();
            head.next = tail;
            tail.prev = head;
            this.size = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            ListNode node = cache.getOrDefault(key, null);
            if (node == null) {
                return -1;
            }
            remove(node);
            addFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            ListNode node = cache.getOrDefault(key, null);
            if (node == null) {
                ListNode newNode = new ListNode();
                newNode.key = key;
                newNode.val = value;
                cache.put(key, newNode);
                addFirst(newNode);
                this.size++;
                if (size > capacity) {
                    ListNode toRemove = tail.prev;
                    remove(toRemove);
                    cache.remove(toRemove.key);
                    this.size--;
                }
            } else {
                node.val = value;
                remove(node);
                addFirst(node);
            }
        }
    }

    private class ListNode {

        public int key;

        public int val;

        public ListNode prev;

        public ListNode next;

        public ListNode() {}
    }

}
