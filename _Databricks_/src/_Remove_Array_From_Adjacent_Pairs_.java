import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _Remove_Array_From_Adjacent_Pairs_ {
    /**
     * Leetcode 1743.
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        // Map to store element -> adjacent elements mapping.
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            int[] pair = adjacentPairs[i];
            int first = pair[0], second = pair[1];
            // Convert adjacent pairs to map.
            map.putIfAbsent(first, new ArrayList<>());
            map.putIfAbsent(second, new ArrayList<>());
            map.get(first).add(second);
            map.get(second).add(first);
        }
        int[] res = new int[adjacentPairs.length + 1];
        int i = 1;
        for (Integer key : map.keySet()) {
            // Find the element with only one values as the head.
            if (map.get(key).size() == 1) {
                res[0] = key;
                res[1] = map.get(key).get(0);
                break;
            }
        }
        while (i < res.length - 1) {
            int curKey = res[i];
            List<Integer> curList = map.get(curKey);
            // Reach the end of the array.
            if (curList.size() == 1) {
                res[i + 1] = curList.get(0);
            } else {
            // Guarantee that res[i + 1] and res[i - 1] has different values.
                res[i + 1] = res[i - 1] == curList.get(0) ? curList.get(1) : curList.get(0);
            }
            i++;
        }
        return res;
    }
}