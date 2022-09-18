import java.util.*;
/**
 * 09/17/2022
 */
public class Leetcode210 {
    /**
     * Leetcode 210 - Course Schedule II (Medium)
     * TC: O(n ^ 2)
     * SC: O(n)
     * (1) Create an array to record the in-degree of course index that need
     *     prerequisites and traverse the array to initialize.
     * (2) Use a queue to add existing 0 in-degree courses and breadth first
     *     search all possible courses and check if new courses can be taken
     *     after updating the in-degree.
     * (3) Return the order array if can finish, empty array otherwise.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] order = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                order[index++] = i;
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == cur) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        order[index++] = prerequisites[i][0];
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return index == numCourses ? order : new int[0];
    }
}
