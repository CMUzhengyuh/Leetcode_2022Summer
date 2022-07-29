/**
 * 07/28/2022
 */
public class Leetcode389 {
    /**
     * Leetcode 389 - Find the Difference (Easy)
     * TC: O(n)
     * SC: O(1)
     * Use XOR operation to find out the singular character.
     */
    public char findTheDifference(String s, String t) {
        char num = 0;
        for (char c : s.toCharArray()) {
            num ^= c;
        }
        for (char c : t.toCharArray()) {
            num ^= c;
        }
        return num;
    }
}
