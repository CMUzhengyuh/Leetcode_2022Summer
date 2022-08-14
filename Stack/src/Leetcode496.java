import java.util.HashMap;
import java.util.Stack;
/**
 * 08/13/2022
 */
public class Leetcode496 {
    /**
     * Leetcode 496 - Next Greater Element I (Easy)
     * TC: O(n)
     * SC: O(n)
     * Use a HashMap to store the element -> next greater element mapping.
     * Traverse the array reversely and maintain monotonic increasing stack.
     * Fill the result array according to the mapping.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}