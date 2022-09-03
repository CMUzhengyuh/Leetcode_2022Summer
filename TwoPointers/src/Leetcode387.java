/**
 * 09/03/2022
 */
public class Leetcode387 {
    /**
     * Leetcode 387 - First Unique Character in a String (Easy)
     * TC: O(n)
     * SC: O(1)
     * Traverse given string twice:
     * (1) Collect the character count in 26-character buckets.
     * (2) Find the first unique one.
     */
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
