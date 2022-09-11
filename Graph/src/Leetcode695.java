/**
 * 09/10/2022
 */
public class Leetcode695 {

    private int res = 0;

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    /**
     * Leetcode 695 - Max Area of Island (Medium)
     * TC: O(m * n)
     * SC: O(m * n)
     * DFS helper function: return the island area of the given index.
     * Traverse the matrix and check the island area for each grids and at the
     * same time. tag all visited ones as visited by flipping 1 to 0.
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = DFS(grid, i, j);
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }

    private int DFS(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int res = 1;
        for (int dir = 0; dir < 4; dir++) {
            int x = i + dirs[dir][0];
            int y = j + dirs[dir][1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length ||
                    grid[x][y] == 0) {
                continue;
            }
            res += DFS(grid, x, y);
        }
        return res;
    }
}
