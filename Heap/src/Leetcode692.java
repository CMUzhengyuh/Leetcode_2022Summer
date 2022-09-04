import java.util.*;
/**
 * 07/18/2022
 */
public class Leetcode692 {
    /**
     * Leetcode 692 - Top K Frequent Words (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * Share the same idea and code with Leetcode 347, but need to reconstruct
     * the comparator for the order requirements.
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((i1, i2) -> map.get(i2) == map.get(i1) ? i1.compareTo(i2) : map.get(i2) - map.get(i1));
        List<String> res = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String key : map.keySet()) {
            pq.add(key);
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;

    }
}
