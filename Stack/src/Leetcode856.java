import java.util.*;
/**
 * 06/26/2022
 */
public class Leetcode856 {
    /**
     * Leetcode 856 - Score of Parentheses (Medium)
     * TC: O(n)
     * SC: O(n)
     * Use a stack to store temp value of parentheses scores:
     * (1) -1 to represent left parenthesis.
     * (2) When a right parenthesis encounter -1 directly, change it to 1.
     * (3) When not -1, calculate the sum first and then multiple 2.
     */
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                stack.push(-1);
            else {
                if (!stack.isEmpty() && stack.peek() == -1)
                {
                    stack.pop();
                    stack.push(1);
                }
                else {
                    int sum = 0;
                    while (!stack.isEmpty() && stack.peek()!=-1) {
                        sum += stack.pop();
                    }
                    stack.pop();
                    stack.push(2*sum);
                }
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
