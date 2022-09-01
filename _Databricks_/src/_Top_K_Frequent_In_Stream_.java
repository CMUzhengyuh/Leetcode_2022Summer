import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Leetcode 347.
 */
public class _Top_K_Frequent_In_Stream_ {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] res = new int[k];
        for (int i = nums.length; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                for (int key : bucket[i]) {
                    res[--k] = key;
                }
            }
        }
        return res;
    }
}
