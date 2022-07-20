import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * 07/19/2022
 */
public class Leetcode743 {
    /**
     * Leetcode 743 - Network Delay Time (Medium)
     * TC: O(N+ElogN)
     * SC: O(N+E)
     * *** Dijksrta Algorithm.
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        Map<Integer, Integer> dist = new HashMap<>();
        for (int[] time : times) {
            List<int[]> list = graph.getOrDefault(time[0], new ArrayList<>());
            list.add(new int[]{time[1], time[2]});
            graph.put(time[0], list);
        }
        pq.add(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int target = cur[0], weight = cur[1];
            if (dist.containsKey(target)) {
                continue;
            }
            dist.put(target, weight);
            if (graph.containsKey(target)) {
                for (int[] edge : graph.get(target)) {
                    pq.add(new int[]{edge[0], edge[1] + weight});
                }
            }
        }
        if (dist.size() != n) return -1;
        int res = Integer.MIN_VALUE;
        for (int num : dist.keySet()) {
            res = Math.max(res, dist.get(num));
        }
        return res;
    }


}
