import java.util.Stack;
/**
 * 08/15/2022
 */
public class Leetcode84 {
    /**
     * Leetcode 84 - Largest Rectangle in Histogram (Hard)
     * TC: O(n)
     * SC: O(n)
     * Traverse the array and maintain a monotonic increasing stack.
     * When the new height is smaller than that of stack top, it means that
     * the interval [top, cur) can form a local largest rectangle whose area is
     * (cur - top - 1) * height[top]. Record the maximum area in the traversal.
     * If the stack is not empty when the traversal reaches to the end, check
     * if there exists larger one with the right boundary.
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int cur = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = width * heights[cur];
                res = Math.max(area, res);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            int area = width * heights[cur];
            res = Math.max(area, res);
        }
        return res;
    }

}
