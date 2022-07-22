/**
 * 07/21/2022
 */
public class Leetcode200 {

    private int[] parent = null;

    private int res = 0;

    private void union(int i, int j) {
        int p1 = find(i), p2 = find(j);
        if (p1 == p2) return;
        parent[p2] = p1;
        res--;
    }

    private int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    /**
     * Leetcode 200 - Number of Islands (Medium)
     * TC: O(n)
     * SC: O(n)
     * Use the array to store the parent index in an island.
     * Maintain an integer to record the total numbers.
     * Every time a union operation happens, decrease the counter.
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                parent[i * n + j] = i * n + j;
                res++;
                if (i > 0 && grid[i - 1][j] == '1') {
                    union((i - 1) * n + j, i * n + j);
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    union(i * n + j - 1, i * n + j);
                }
            }
        }
        return res;
    }
}
