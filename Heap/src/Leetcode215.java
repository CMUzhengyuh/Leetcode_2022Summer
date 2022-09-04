import java.util.*;
/**
 * 07/17/2022
 */
public class Leetcode215 {
    /**
     * Leetcode 215 - Kth Largest Element in an Array (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * Share the same idea with Leetcode 703 (streaming data).
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
