import java.util.*;
/**
 * 06/22/2022
 */
public class Leetcode682 {
    /**
     * Leetcode 682 - Baseball Game (Easy)
     * TC: O(n)
     * SC: O(n)
     * Use stack to store temporary integers then dump and add all the numbers.
     */
    public int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if ("+".equals(op)) {
                int second = stack.pop(), first = stack.peek();
                stack.push(second);
                stack.push(first + second);
            } else if ("D".equals(op)) {
                stack.push(2 * stack.peek());
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}