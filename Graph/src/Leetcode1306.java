import java.util.*;
/**
 * 09/17/2022
 */
public class Leetcode1306 {
    /**
     * Leetcode 1306 - Jump Game III (Medium)
     * TC: O(n)
     * SC: O(n)
     * Breadth first search the array to find out if every possible point
     * that starts from given one have value = 0.
     */
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            if (arr[cur] == 0) {
                return true;
            }
            int left = cur - arr[cur], right = cur + arr[cur];
            if (left >= 0 && !visited[left]) {
                q.add(left);
            }
            if (right < n && !visited[right]) {
                q.add(right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode1306 Solution = new Leetcode1306();
        System.out.println(Solution.canReach(new int[]{3, 0, 2, 1, 2}, 2));
    }
}
