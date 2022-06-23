import java.util.LinkedList;
import java.util.Queue;
/**
 * 06/22/2022
 */
public class Leetcode225 {
    /**
     * Leetcode 225 - Implement Stack using Queues (Easy)
     * The underlying data structure is a queue:
     * For push operation, first add the new element and dump all elements
     * above the newest so that it becomes the first, which the total time
     * complexity is O(n). Other operations are quit similar to basic ones.
     */
    class MyStack {

        Queue<Integer> q = new LinkedList<>();

        public void push(int x) {
            q.add(x);
            for(int i = 1; i < q.size(); i++)
                q.add(q.poll());
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
