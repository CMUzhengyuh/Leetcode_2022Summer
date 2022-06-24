import java.util.Stack;
/**
 * 06/23/2022
 */
public class Leetcode1190 {
    /**
     * Leetcode 1190 - Reverse Substrings Between Each Pair of Parentheses (Medium)
     * TC: O(n)
     * SC: O(n)
     * Utilize the stack to store the range of a pair of parentheses.
     */
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
