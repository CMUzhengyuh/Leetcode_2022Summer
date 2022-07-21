import java.util.PriorityQueue;
/**
 * 07/20/2022
 */
public class Leetcode973 {
    /**
     * Leetcode 973 - K Closest Points to Origin (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * Override the comparator with the distance.
     */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]));
        int[][] res = new int[k][2];
        for (int[] point : points) {
            pq.add(point);
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
