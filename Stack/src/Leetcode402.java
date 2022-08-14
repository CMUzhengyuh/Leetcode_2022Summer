import java.util.Stack;
/**
 * 08/13/2022
 */
public class Leetcode402 {
    /**
     * Leetcode 402 - Remove K Digits (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) Traverse the string and maintain a monotonic increasing stack when
     *     removal is available.
     * (2) Form the string according to the remaining digits in the stack.
     * (3) Remove starting zeros in the string.
     */
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k-- > 0) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
