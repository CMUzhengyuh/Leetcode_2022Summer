/**
 * 10/02/2022
 */
public class Leetcode2222 {
    /**
     * Leetcode 2222 - Number of Ways to Select Buildings (Medium)
     * TC: O(n)
     * SC: O(1)
     * Whenever reaching a position, there are three possibilities:
     * (1) The first slot, then add count0 or count1 correspondingly.
     * (2) The second slot, then calculate the pattern of '01' or '10'.
     * (3) The last slot, the add to result according to existing patterns.
     */
    public long numberOfWays(String s) {
        long count1 = 0, count0 = 0, count10 = 0, count01 = 0, res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                count0++;
                count10 += count1;
                res += count01;
            } else {
                count1++;
                count01 += count0;
                res += count10;
            }
        }
        return res;
    }
}
