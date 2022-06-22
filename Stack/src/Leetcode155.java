import java.util.Stack;
/**
 * 06/21/2022
 */
public class Leetcode155 {
    /**
     * Leetcode 155 - Min Stack (Easy)
     * The underlying data structure is two stacks:
     * (1) Min stack to support minimum elements.
     * (2) Basic stack to support fundamental stack operations.
     * When a new elements get pushed, check if it becomes the new smallest.
     * When pop the to element, also check if it is the concurrent smallest.
     */
    class MinStack {

        private Stack<Integer> stack = new Stack<>();

        private Stack<Integer> min = new Stack<>();

        public MinStack() { }

        public void push(int x) {
            stack.push(x);
            if (min.isEmpty() || x <= min.peek()) {
                min.push(x);
            }
        }

        public void pop() {
            if (stack.peek().equals(min.peek())) {
                min.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

}
