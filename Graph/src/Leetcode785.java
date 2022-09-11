import java.util.*;
/**
 * 09/10/2022
 */
public class Leetcode785 {
    /**
     * Leetcode 785 - Is Graph Bipartite? (Medium)
     * TC: O(n + e)
     * SC: O(n)
     * Utilize two sets to record different nodes in the graph.
     * The solution works as follows:
     * (1) Add non-empty array of an index to the queue as initialization.
     * (2) Keeps moving a node from the queue to see whether a pair of
     *     connections violate the bipartite rule. If not, assign unvisited
     *     nodes to corresponding sets. (Addition is idempotent!)
     * (3) When the queue keep iterating without moving forwards n times,
     *     assign the next node to set A by force to prevent deadlock.
     */
    public boolean isBipartite(int[][] graph) {
        Set<Integer> setA = new HashSet<>(), setB = new HashSet<>();
        setA.add(0);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                continue;
            }
            q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            if (count == graph.length) {
                setA.add(u);
                count = 0;
            }
            if (!setA.contains(u) && !setB.contains(u)) {
                q.add(u);
                count++;
                continue;
            }
            count = 0;
            int[] conn = graph[u];
            boolean inSetA = setA.contains(u);
            for (int v : conn) {
                if (inSetA) {
                    if (setA.contains(v)) {
                        return false;
                    }
                    setB.add(v);
                } else {
                    if (setB.contains(v)) {
                        return false;
                    }
                    setA.add(v);
                }
            }
        }
        return true;
    }
}
