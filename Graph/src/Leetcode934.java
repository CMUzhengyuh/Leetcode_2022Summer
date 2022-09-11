import java.util.*;
/**
 * 09/10/2022
 */
public class Leetcode934 {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private Queue<int[]> q = new LinkedList<>();
    /**
     * Leetcode 934 - Shortest Bridge (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) Find a grid of land in the loop.
     * (2) Depth first search from this point and add all grids of land into
     *     the queue. (Also tag them as visited)
     * (3) Breadth first search from all possible points in the queue and check
     *     if reaching a unvisited land, if so, current level is the shortest.
     */
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = 0, j = 0;
        boolean[][] visited = new boolean[m][n];
        loop:
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    break loop;
                }
            }
        }
        q.add(new int[]{i, j});
        visited[i][j] = true;
        DFS(grid, i, j, visited);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int p = 0; p < size; p++) {
                int[] pos = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = pos[0] + dirs[k][0], y = pos[1] + dirs[k][1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                            || visited[x][y]) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return level;
                    }
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            level++;
        }

        return 0;

    }

    private void DFS(int[][] grid, int i, int j, boolean[][] visited) {
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k][0], y = j + dirs[k][1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                    || grid[x][y] == 0 || visited[x][y]) {
                continue;
            }
            q.add(new int[]{x, y});
            visited[x][y] = true;
            DFS(grid, x, y, visited);
        }
    }
}
