/**
 * 07/28/2022
 */
public class Leetcode169 {
    /**
     * Leetcode 169 - Majority Element (Easy)
     * TC: O(n)
     * SC: O(1)
     * Boyer-Moore Voting Algorithm:
     * Initialize an element m and a counter i with i = 0.
     * For each element num in the array:
     * (1) i == 0: assign m = num and i++.
     * (2) m == num: i++.
     * (3) m != num: i--.
     */
    public int majorityElement(int[] nums) {
        int res = Integer.MAX_VALUE, time = 0;
        for (int num : nums) {
            if (res != num) {
                if (time == 0) {
                    res = num;
                    time = 1;
                } else {
                    time--;
                }
            } else {
                time++;
            }
        }
        return res;
    }
}
