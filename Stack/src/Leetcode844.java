import java.util.*;
/**
 * 06/22/2022
 */
public class Leetcode844 {
    /**
     * Leetcode 844 - Backspace String Compare (Easy)
     * TC: O(n)
     * SC: O(n)
     * Use one stack to verify the result string with forward traversing the
     * first string and backward traversing the second one.
     * *** The optimal solution with O(1) space complexity is using two
     *     pointers from right boundaries of two strings to verify.
     */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else stack.push(c);
        }
        int back = 0;
        for (int i = t.length() - 1; i >= 0; i--) {
            char c = t.charAt(i);
            if (c == '#') {
                back++;
            } else {
                if (back > 0) {
                    back--;
                    continue;
                }
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}