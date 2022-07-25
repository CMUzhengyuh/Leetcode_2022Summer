/**
 * 07/24/2022
 */
public class Leetcode1631 {

    private int[] parent = new int[0];

    private void union(int i, int j) {
        int p1 = find(i), p2 = find(j);
        if (p1 > p2) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
        }
    }

    private int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    /**
     * Leetcode 1319 - Number of Operations to Make Network Connected (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * Result binary search possible effort from 0 to maximum gap in the graph.
     * Union adjacent node if the difference is smaller than given k.
     * Then determine the minimum possible effort for the global.
     */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(heights[i][j], max);
                min = Math.min(heights[i][j], min);
            }
        }
        int left = 0, right = max - min;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (connected(heights, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean connected(int[][] heights, int k) {
        int m = heights.length, n = heights[0].length;
        parent = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                parent[i * n + j] = i * n + j;
                if (i > 0 && Math.abs(heights[i][j] - heights[i - 1][j]) <= k) {
                    union(i * n + j, i * n + j - n);
                }
                if (j > 0 && Math.abs(heights[i][j] - heights[i][j - 1]) <= k) {
                    union(i * n + j, i * n + j - 1);
                }
            }
        }
        return find(0) == find(m * n - 1);
    }
}
