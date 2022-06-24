import java.util.Stack;
/**
 * 06/23/2022
 */
public class Leetcode456 {
    /**
     * Leetcode 456 - 132 Pattern (Medium)
     * TC: O(n)
     * SC: O(n)
     * First, traverse the array to record the minimum value for each position.
     * Then, traverse from back and verify the pattern according to conditions:
     * (1) < min[cur], impossible to become valid pattern.
     * (2) > min[cur], could become '2' position so push to the stack.
     * Considering that min array is non-increasing, in backward traversal,
     * the stack need to check whether '1' value is still correct.
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
