import java.util.*;
/**
 * 08/15/2022
 */
public class Leetcode42 {
    /**
     * Leetcode 42 - Trapping Rain Water (Hard)
     * TC: O(n)
     * SC: O(n)
     * Maintain a monotonic decreasing stack.
     * Every time current height is higher than that of the stack top position:
     * (1) Pop the stack pop and check if there is still elements. When the
     *     stack is empty, it means there is no left boundary, hence continue.
     * (2) Record new stack top index as left and current position as right:
     *     Calculate the width of water = (right - left - 1).
     *     Calculate the height of water = min(height[left], height[right])
     * (3) Add to result: width * height.
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int val = stack.pop();
                if (stack.isEmpty()) continue;
                int depth = Math.min(height[stack.peek()], height[i]) - height[val];
                res += depth * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }

}
