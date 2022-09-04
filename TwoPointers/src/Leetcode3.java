/**
 * 09/03/2022
 */
public class Leetcode3 {
    /**
     * Leetcode 3 - Longest Substring Without Repeating Characters (Medium)
     * TC: O(n)
     * SC: O(1)
     * Use a boolean array of character size to store existed character.
     * Two pointers move from the starting point and when right pointer reaches
     * an existed character, move forward the left pointer to make it unique
     * again, record the maximum substring length during the process.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        boolean[] map = new boolean[255];
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            while (map[(int) s.charAt(right)]) {
                map[(int) s.charAt(left++)] = false;
            }
            res = Math.max(res, right - left + 1);
            map[(int) s.charAt(right++)] = true;
        }
        return res;
    }
}
