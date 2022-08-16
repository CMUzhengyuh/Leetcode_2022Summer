import java.util.Stack;
/**
 * 08/16/2022
 */
public class Leetcode85 {
    /**
     * Leetcode 85 - Maximal Rectangle (Hard)
     * TC: O(n)
     * SC: O(n)
     * Use Leetcode 84 solution as a helper function.
     * (1) Accumulate the height of elements for each column from top to end.
     * (2) For each layer, calculate the local maximum rectangle area.
     * (3) When traversing the whole matrix, the result is the global maximum.
     */
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int[] prefix = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < prefix.length; j++) {
                if (i == 0) {
                    prefix[j] = matrix[i][j] - '0';
                } else {
                    prefix[j] = matrix[i][j] == '0' ? 0 : prefix[j] + 1;
                }
            }
            res = Math.max(res, largestRectangleArea(prefix));
        }
        return res;
    }

    /**
     * Leetcode 84 Solution.
     */
    private int largestRectangleArea(int[] heights) {
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
