import java.util.*;
/**
 * 08/13/2022
 */
public class Leetcode739 {
    /**
     * Leetcode 739 - Daily Temperatures (Medium)
     * TC: O(n)
     * SC: O(n)
     * Traverse the array reversely and maintain monotonic increasing stack.
     * Fill the result with the difference between current and stack pop date.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = !stack.isEmpty() ? stack.peek() - i : 0;
            stack.push(i);
        }
        return res;
    }
}
