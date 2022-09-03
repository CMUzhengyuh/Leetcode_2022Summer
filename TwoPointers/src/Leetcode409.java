/**
 * 09/03/2022
 */
public class Leetcode409 {
    /**
     * Leetcode 409 - Longest Palindrome (Easy)
     * TC: O(n)
     * SC: O(1)
     * Palindrome: at most one character with odd frequency.
     * Collect the character count in character buckets.
     * Calculate the number of odd frequency and find out the res.
     */
    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[] map = new int[255];
        for (char c : s.toCharArray()) {
            map[c - 0]++;
        }
        int odd = 0;
        for (int i = 0; i < 255; i++) {
            if (map[i] % 2 != 0) {
                odd++;
            }
        }
        return s.length() - (odd > 0 ? odd - 1 : odd);

    }
}
