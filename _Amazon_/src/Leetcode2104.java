import java.util.*;
/**
 * 10/01/2022
 */
public class Leetcode2104 {
    /**
     * Leetcode 2104 - Sum of Subarray Ranges (Medium)
     * TC: O(n)
     * SC: O(n)
     * This problem can be derived from two sub-problem:
     * Calculate the sum of minimum and maximum elements of subarray ranges.
     * Those two sub-problems are both under monotonic stack topics:
     * Take sum of minimum as an example:
     * (1) Create an auxiliary stack and maintain decreasing and two arrays.
     * (2) Those two arrays record the length of left and right wings of given
     *     index that acts as minimum elements.
     * (3) Traverse the array and update the stack and left array value every
     *     time and after the traversal, dump all elements to update the rest
     *     of right array value.
     * (4) Sum of minimum elements of all subarray ranges:
     *     res = sum of (nums[i] * left[i] * right[i]);
     */
    public long subArrayRanges(int[] nums) {
        return sumOfMax(nums) - sumOfMin(nums);
    }

    private long sumOfMin(int[] nums) {
        Stack<Integer> min = new Stack<>();
        int n = nums.length;
        long res = 0;
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!min.isEmpty() && nums[min.peek()] > nums[i]) {
                right[min.peek()] = i - min.peek();
                min.pop();
            }
            left[i] = min.isEmpty() ? i + 1 : i - min.peek();
            min.push(i);
        }
        while (!min.isEmpty()) {
            int top = min.pop();
            right[top] = n - top;
        }
        for (int i = 0; i < n; i++) {
            res += (long) nums[i] * right[i] * left[i];
        }
        return res;
    }

    private long sumOfMax(int[] nums) {
        Stack<Integer> max = new Stack<>();
        int n = nums.length;
        long res = 0;
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!max.isEmpty() && nums[max.peek()] < nums[i]) {
                right[max.peek()] = i - max.peek();
                max.pop();
            }
            left[i] = max.isEmpty() ? i + 1 : i - max.peek();
            max.push(i);
        }
        while (!max.isEmpty()) {
            int top = max.pop();
            right[top] = n - top;
        }
        for (int i = 0; i < n; i++) {
            res += (long) nums[i] * right[i] * left[i];
        }
        return res;
    }
}
