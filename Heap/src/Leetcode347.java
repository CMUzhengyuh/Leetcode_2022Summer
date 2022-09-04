import java.util.*;
/**
 * 07/17/2022
 */
public class Leetcode347 {
    /**
     * Leetcode 347 - Top K Frequent Elements (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * Firstly, construct a map to store number -> frequency mapping.
     * Secondly, create a max-Heap to sort the elements based on the frequency.
     * Then return the top K elements in the heap.
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> map.get(i2) - map.get(i1));
        int[] res = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            pq.add(key);
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
