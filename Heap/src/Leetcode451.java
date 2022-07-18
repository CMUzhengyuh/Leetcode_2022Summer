import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * 07/18/2022
 */
public class Leetcode451 {
    /**
     * Leetcode 451 - Sort Characters By Frequency (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * Share the same idea with Leetcode 347, create the mapping of character
     * to frequency, add to max-Heap based on frequency and build the string.
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : map.keySet()) {
            pq.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
