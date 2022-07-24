/**
 * 07/23/2022
 */
public class Leetcode130 {

    private int[] parent = new int[0];

    private boolean[] surrounded = new boolean[0];

    public int find(int i) {
        int cur = i;
        while (parent[cur] != cur) {
            cur = parent[cur];
        }
        return cur;
    }

    public void union(int i, int j) {
        int p1 = find(i), p2 = find(j);
        if (p1 > p2) {
            parent[p1] = p2;
            surrounded[p1] |= surrounded[p2];
            surrounded[p2] |= surrounded[p1];
        } else {
            parent[p2] = p1;
            surrounded[p2] |= surrounded[p1];
            surrounded[p1] |= surrounded[p2];
        }
    }

    /**
     * Leetcode 130 - Surrounded Regions (Medium)
     * TC: O(n)
     * SC: O(n)
     * In the first traversal, update the parent mapping and surrounded.
     * In the second traversal, flip the character if the region surrounded.
     */
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        parent = new int[m * n];
        surrounded = new boolean[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                parent[i * n + j] = i * n + j;
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    surrounded[i * n + j] = true;
                }
                if (i > 0 && board[i - 1][j] == 'O') {
                    union(i * n + j, i * n + j - n);
                }
                if (j > 0 && board[i][j - 1] == 'O') {
                    union(i * n + j, i * n + j - 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !surrounded[find(i * n + j)] ) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
