import java.util.Stack;
/**
 * 06/26/2022
 */
public class Leetcode503 {
    /**
     * Leetcode 503 - Next Greater Element II (Medium)
     * TC: O(n)
     * SC: O(n)
     * Maintain a monotonic decreasing stack of index, traverse backward.
     * In the first traversal, only update the stack value.
     * In the second traversal, record the next great element from the stack
     */
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            stack.push(i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) res[i] = -1;
            else res[i] = nums[stack.peek()];
            stack.push(i);
        }
        return res;
    }
}
