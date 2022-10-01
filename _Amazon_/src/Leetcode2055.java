import java.util.*;
/**
 * 09/30/2022
 */
public class Leetcode2055 {
    /**
     * Leetcode 2055 - Plates Between Candles (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * Use the TreeMap to store the index -> accumulated candle numbers.
     * For a given query, find out the first candle position after the left
     * boundary and last candle position before the right boundary and the
     * number of plates between those two candles can be derived as:
     * res[i] = right - left - (map[right] - map[left]).
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                map.put(i, index++);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer index1 = map.ceilingKey(queries[i][0]);
            Integer index2 = map.floorKey(queries[i][1]);
            if (index1 == null || index2 == null || index2 <= index1) {
                continue;
            }
            int place1 = map.get(index1);
            int place2 = map.get(index2);
            ans[i] = index2 - index1 - (place2 - place1);
        }
        return ans;
    }
}
