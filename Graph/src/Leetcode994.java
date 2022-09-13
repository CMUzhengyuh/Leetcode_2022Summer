import java.util.*;
/**
 * 09/11/2022
 */
public class Leetcode994 {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    /**
     * Leetcode 994 - Rotting Oranges (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) Tag all empty cell as visited and add all rotten one to the queue.
     * (2) Breadth first search until all the queue is empty.
     * (3) If the total count of unvisited cells equals to zero, that means
     *     that it is impossible to pollute all cells. Otherwise, return depth.
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, total = m * n;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    total--;
                }
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                total--;
                for (int d = 0; d < 4; d++) {
                    int x = cur[0] + dirs[d][0];
                    int y = cur[1] + dirs[d][1];
                    if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) {
                        continue;
                    }
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
            if (q.isEmpty()) {
                return total == 0 ? level : -1;
            }
            level++;
        }
        return total == 0 ? level : -1;
    }
}
