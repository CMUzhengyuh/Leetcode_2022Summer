import java.util.*;
/**
 * 10/03/2022
 */
public class Leetcode2268 {
    /**
     * Leetcode 2268 - Minimum Number of Keypresses (Medium)
     * TC: O(n)
     * SC: O(1)
     * (1) Calculate the frequency of each character.
     * (2) Sort the frequency array and assign the highest 9 to the first
     *     character and rank 10 through 18 to the second character.
     */
    public int minimumKeypresses(String s) {
        int res = 0;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        for (int i = 0; i < 26; i++) {
            res += freq[i] * ((25 - i) / 9 + 1);
        }
        return res;
    }
}
