import java.util.Stack;
/**
 * 06/20/2022
 */
public class Leetcode20 {
    /**
     * Leetcode 20 - Valid Parentheses (Easy)
     * TC: O(n)
     * SC: O(n)
     * Add the left parenthesis and check the right parenthesis to verify.
     * Check the size of stack after traversal to prevent redundant Parentheses.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch(c) {
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }
        return stack.isEmpty();
    }
}