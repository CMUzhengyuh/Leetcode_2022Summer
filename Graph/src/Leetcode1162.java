import java.util.*;
/**
 * 09/12/2022
 */
public class Leetcode1162 {
    /**
     * Leetcode 1162 - As Far from Land as Possible (Medium)
     * TC: O(n ^ 2)
     * SC: O(n ^ 2)
     * (1) Traverse the matrix and count the number of land, set the visited
     *     mark as true and add existed land to the queue.
     * (2) Breadth first search until the queue is clear to four directions,
     *     record the depth of traversal to maximum.
     * (3) Return -1 if all grids are land or water, level - 1 otherwise.
     */
    public int maxDistance(int[][] grid) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int sum = 0, level = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                    visited[i][j] = true;
                    q.add(new int[]{i, j});
                }
            }
        }
        if (sum == 0 || sum == m * n) {
            return -1;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];
                for (int d = 0; d < 4; d++) {
                    int x = i + dirs[d][0], y = j + dirs[d][1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                        continue;
                    }
                    sum++;
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
            level++;
        }
        return level - 1;
    }
}
