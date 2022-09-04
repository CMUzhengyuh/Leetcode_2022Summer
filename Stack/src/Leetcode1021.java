import java.util.*;
/**
 * 06/22/2022
 */
public class Leetcode1021 {
    /**
     * Leetcode 1021 - Remove Outermost Parentheses (Easy)
     * TC: O(n)
     * SC: O(n)
     * The key point is to judge whether current parenthesis is the outermost.
     */
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == '(') {
                    stack.push(c);
                    sb.append(c);
                } else {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
