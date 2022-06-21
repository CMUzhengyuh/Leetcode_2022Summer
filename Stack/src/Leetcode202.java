import java.util.Stack;
/**
 * 06/21/2022
 */
public class Leetcode202 {
    /**
     * Leetcode 202 - Implement Queue using Stacks (Easy)
     * The underlying data structure is two stacks:
     * (1) Head stack is responsible for front operations.
     * (2) Tail stack is responsible for back operations.
     * The initial status is that both stacks are empty. When a new element
     * comes for push, it adds to tail stack first. When a front operation
     * is called at the first time, dump elements from tail to head to find
     * out the front elements. Although the dump operation takes O(n) time
     * complexity, the overall time complexity is amortized O(1).
     */
    class MyQueue {

        private Stack<Integer> head, tail;

        public MyQueue() {
            head = new Stack<>();
            tail = new Stack<>();
        }

        public void push(int x) {
            tail.push(x);
        }

        public int pop() {
            if (head.isEmpty()) {
                while (!tail.isEmpty()) {
                    head.push(tail.pop());
                }
            }
            return head.pop();
        }

        public int peek() {
            if (!head.isEmpty()) {
                return head.peek();
            } else {
                while (!tail.isEmpty()) {
                    head.push(tail.pop());
                }
            }
            return head.peek();
        }

        public boolean empty() {
            return head.isEmpty() && tail.isEmpty();
        }
    }
}
