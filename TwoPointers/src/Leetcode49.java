import java.util.*;
/**
 * 09/03/2022
 */
public class Leetcode49 {
    /**
     * Leetcode 49 - Group Anagrams (Medium)
     * TC: O(n * L), L = maximum # of characters in strs elements.
     * SC: O(n * L)
     * For each string in the given array, calculate the count bucket and check
     * if existed in the HashMap. If existed, add it to existing list and
     * create a new one otherwise. Finally, the value set of map is the result,
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] count = new char[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String keyStr = String.valueOf(count);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
