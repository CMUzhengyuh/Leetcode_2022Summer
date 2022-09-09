import java.util.*;
/**
 * 09/08/2022
 */
public class Leetcode32 {
    /**
     * Leetcode 32 - Longest Valid Parentheses (Hard)
     * TC: O(n)
     * SC: O(n)
     * The left pointer record the last index that has no matching parenthesis.
     * When encountering a right parenthesis:
     * (1) Empty stack so that no matching left parenthesis, update pointer.
     * (2) Pop the top elements and update current maximum length as:
     *     cur - left or cur - top according to whether the stack is empty.
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) =='(') {
                stack.push(j);
            } else {
                if (stack.isEmpty()) {
                    left = j;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, j - left);
                    } else {
                        max = Math.max(max, j - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
