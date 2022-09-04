import java.util.*;
/**
 * 07/17/2022
 */
public class Leetcode1046 {
    /**
     * Leetcode 1046 - Last Stone Weight (Easy)
     * TC: O(nlogn)
     * SC: O(n)
     * Use the characteristic of max-Heap.
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer i1, Integer i2) -> i2 - i1);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() >= 2) {
            int m = pq.poll(), n = pq.poll();
            if (m > n) {
                pq.add(m - n);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
