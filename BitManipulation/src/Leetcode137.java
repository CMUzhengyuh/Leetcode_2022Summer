/**
 * 07/30/2022
 */
public class Leetcode137 {
    /**
     * Leetcode 137 - Single Number II (Medium)
     * TC: O(n)
     * SC: O(1)
     * Bitwise operation to record the frequency of each number.
     * For each digit, the '1' of ones represent '1' of this digit appears
     * once while '1' of twos represent '1' of the digit appears twice.
     * When '1' first emerges, ones = 1 and twos = 0.
     * When '1' emerges again, ones = 0 and twos = 1.
     * For the third time, ones = 0 and twos = 0.
     * The three possibilities form a state machine 00 -> 01 -> 10 -> 00.
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
