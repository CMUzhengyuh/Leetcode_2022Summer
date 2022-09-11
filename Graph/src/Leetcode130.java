/**
 * 09/10/2022
 */
public class Leetcode130 {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * Leetcode 130 - Surrounded Regions (Medium)
     * TC: O(n)
     * SC: O(n)
     * DFS helper function: change all 'O' to '*'.
     * In the main function, try to start from all 'O' pointers that lies in
     * the border of the matrix and adopt DFS based on them. Then traverse the
     * whole matrix with all '*' converted to 'O' and others converted to 'X'.
     */
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {

                DFS(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                DFS(board, i, board[0].length - 1);
            }
        }
        for (int j = 1; j < board[0].length - 1; j++) {
            if (board[0][j] == 'O') {
                DFS(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                DFS(board, board.length - 1, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void DFS(char[][] board, int i, int j) {
        board[i][j] = '*';
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k][0], y = j + dirs[k][1];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
                continue;
            }
            DFS(board, x, y);
        }
    }
}
