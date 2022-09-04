import java.util.*;
/**
 * 06/20/2022
 */
public class Leetcode1047 {
    /**
     * Leetcode 1047 - Remove All Adjacent Duplicates In String (Easy)
     * TC: O(n)
     * SC: O(n)
     * Push characters to stack sequentially to check duplicates occurs.
     * Pop all characters in stack to string and reverse the string to result.
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}