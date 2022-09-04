import java.util.*;
/**
 * 07/26/2022
 */
public class Leetcode128 {

    private int maxSize = 1;

    private int[] parent = new int[0];

    private int[] size = new int[0];

    private void union(int i, int j) {
        int p1 = find(i), p2 = find(j);
        if (p1 > p2) {
            parent[p1] = p2;
            size[p2] += size[p1];
            maxSize = Math.max(size[p2], maxSize);
        } else if (p1 < p2) {
            parent[p2] = p1;
            size[p1] += size[p2];
            maxSize = Math.max(size[p1], maxSize);
        }
    }

    private int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    /**
     * Leetcode 128 - Longest Consecutive Sequence (Medium)
     * TC: O(n)
     * SC: O(n)
     * Use a HashMap to store the num -> index mapping.
     * Then traverse every element and find if exists adjacent integers.
     * Pay attention to repeated elements.
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        parent = new int[nums.length];
        size = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) continue;
            map.put(nums[i], i);
            parent[i] = i;
            size[i] = 1;
            if (map.containsKey(num - 1)) {
                union(map.get(num), map.get(num - 1));
            }
            if (map.containsKey(num + 1)) {
                union(map.get(num), map.get(num + 1));
            }
        }
        return maxSize;
    }

    /**
     * Corner Case: []
     */
}
