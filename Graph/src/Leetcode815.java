import java.util.*;
/**
 * 09/13/2022
 */
public class Leetcode815 {
    /**
     * Leetcode 815 - Bus Routes (Hard)
     * TC: O(n), n = # of node route[i][j]
     * SC: O(n), n = # of node route[i][j]
     * Utilize a HashMap to record stop -> route number mapping.
     * (1) Initialize the map from the original array.
     * (2) Breadth first search from the source point and traverse every route
     *     that not visited and add all possible stops in these routes back to
     *     the queue.
     * (3) When reaching the target stop, return the depth and if impossible to
     *     reach, return -1 finally.
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                map.putIfAbsent(stop, new ArrayList<>());
                map.get(stop).add(i);
            }
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == target) {
                    return level;
                }
                for (int index : map.get(cur)) {
                    if (set.contains(index)) {
                        continue;
                    }
                    for (int next : routes[index]) {
                        q.add(next);
                    }
                    set.add(index);
                }
            }
            level++;
        }
        return -1;
    }
}
