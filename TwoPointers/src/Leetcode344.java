/**
 * 09/03/2022
 */
public class Leetcode344 {
    /**
     * Leetcode 344 - Reverse String (Easy)
     * TC: O(n)
     * SC: O(1)
     * Swap left and right characters until pointers meet.
     */
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
