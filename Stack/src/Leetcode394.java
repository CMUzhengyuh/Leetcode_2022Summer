import java.util.Stack;
/**
 * 06/23/2022
 */
public class Leetcode394 {
    /**
     * Leetcode 394 - Decode String (Medium)
     * TC: O(n)
     * SC: O(n)
     * Backtrack the string and multiples when reaching the right parenthesis.
     * One pitfall is that the numbers could have more than one digit.
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!("[").equals(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.pop();
                String str = sb.toString();
                StringBuilder digit = new StringBuilder();
                while (!stack.isEmpty() && ("0").compareTo(stack.peek()) <= 0
                        && ("9").compareTo(stack.peek()) >= 0) {
                    digit.append(stack.pop());
                }
                int times = Integer.valueOf(digit.reverse().toString());
                for (int i = 1; i < times; i++) {
                    sb.append(str);
                }
                stack.push(sb.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }
        StringBuilder temp = new StringBuilder();
        while (!stack.isEmpty()) {
            temp.append(stack.pop());
        }
        return temp.reverse().toString();
    }
}
