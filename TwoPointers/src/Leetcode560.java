import java.util.*;
/**
 * 09/04/2022
 */
public class Leetcode560 {
    /**
     * Leetcode 560 - Subarray Sum Equals K (Medium)
     * TC: O(n)
     * SC: O(n)
     * Use a HashMap to record the prefix -> frequency mapping.
     * Traverse the array and update the prefix, add the count of existing
     * map key equals to (prefix - k).
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0, res = 0;
        for (int num : nums) {
            prefix += num;
            res += map.getOrDefault(prefix - k, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }
}
