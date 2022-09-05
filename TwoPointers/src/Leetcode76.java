import java.util.*;
/**
 * 09/04/2022
 */
public class Leetcode76 {
    /**
     * Leetcode 76 - Minimum Window Substring (Medium)
     * TC: O(m + n)
     * SC: O(m + n)
     * (1) Create the HashMap to record character -> frequency mapping for t.
     * (2) Left and right pointer starts from 0. Then start the traversal:
     *     Every time move the right pointer and check if current window can
     *     cover every character in the t. If so, we update the minimum length
     *     and check if narrow the window is possible (move left pointer).
     * (3) After the traversal, we can determine whether the substring exists.
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }
        return s.substring(minLeft, minLeft + minLen);
    }
}
