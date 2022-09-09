import java.util.*;
/**
 * 09/07/2022
 */
public class Leetcode354 {
    /**
     * Leetcode 32 - Longest Valid Parentheses (Hard)
     * TC: O(nlogn)
     * SC: O(n)
     * The problem can be divided into two sub-problem:
     * (1) Given the sorted envelope array with increasing width first and
     *     decreasing height if width tied. Generate the height sequence.
     * (2) Fetch the length of longest increasing subsequence of given array.
     *     (This is also Leetcode 300)
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            temp[left] = num;
            if (left == size) size++;
        }
        return size;
    }
}
