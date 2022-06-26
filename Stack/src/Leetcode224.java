import java.util.Stack;
/**
 * 06/25/2022
 */
public class Leetcode224 {
    /**
     * Leetcode 224 - Basic Calculator (Hard)
     * TC: O(n)
     * SC: O(n)
     * Divide the character into three basic categories:
     * (1) Digit: add until encountering a operator or parenthesis.
     * (2) Operator: Calculate the result with two numbers.
     * (3) Parenthesis: consider expressions within parentheses as a layer.
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (number != 0) result += sign * number;
        return result;
    }
}
