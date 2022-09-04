import java.util.*;
/**
 * 06/25/2022
 */
public class Leetcode150 {
    /**
     * Leetcode 150 - Evaluate Reverse Polish Notation (Medium)
     * TC: O(n)
     * SC: O(n)
     * When meeting an operator, pop out two elements and push back results.
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                int target = stack.pop();
                stack.push(stack.pop() / target);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
