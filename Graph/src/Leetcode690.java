import java.util.*;
/**
 * 09/10/2022
 */
public class Leetcode690 {
    /**
     * Leetcode 690 - Employee Importance (Medium)
     * TC: O(n)
     * SC: O(n)
     * Use two HashMaps to record two pairs of relationships:
     * ID -> subordinates mapping and ID -> Employee object mapping.
     * Initialize those two maps first and find the target id.
     * The breadth first search starts from the id and accumulates the result.
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Employee> map = new HashMap<>();
        int target = -1;
        for (Employee e : employees) {
            graph.put(e.id, e.subordinates);
            map.put(e.id, e);
            if (e.id == id) {
                target = id;
            }
        }
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Employee cur = map.get(q.poll());
                res += cur.importance;
                q.addAll(graph.get(cur.id));
            }
        }
        return res;
    }

    private class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
