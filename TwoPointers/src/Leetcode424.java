/**
 * 09/06/2022
 */
public class Leetcode424 {
    /**
     * Leetcode 424 - Longest Repeating Character Replacement (Medium)
     * TC: O(n)
     * SC: O(1)
     * Use an array to store the frequency of each uppercase characters.
     * Two pointers start from the left boundary, first find out the max count
     * of character frequency for current time window, then calculate number
     * of characters need to change to the one with max count. In case of
     * changing number violate the restriction of k, narrow the time window.
     * Keep track of the longest sub-string during the process.
     */
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxCount = 0;
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);
            int change = (right - left + 1) - maxCount;
            if (change > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
