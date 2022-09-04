import java.util.*;
/**
 * 07/17/2022
 */
public class Leetcode703 {
    /**
     * Leetcode 703 - Kth Largest Element in a Stream (Easy)
     * The underlying data structure is a min-Heap stores maximum k elements.
     * Every time a new element is added, pop out the top element if the value
     * is larger than it when the size equals to k, otherwise add directly.
     */
    class KthLargest {

        private PriorityQueue<Integer> pq;

        private int size;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            size = k;
            for (int num : nums) {
                this.add(num);
            }
        }

        public int add(int val) {
            if (pq.size() == size) {
                if (pq.peek() < val) {
                    pq.poll();
                    pq.add(val);
                }
            } else {
                pq.add(val);
            }
            return pq.peek();
        }
    }
}
