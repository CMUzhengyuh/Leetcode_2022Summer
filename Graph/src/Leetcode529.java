import java.util.*;
/**
 * 09/12/2022
 */
public class Leetcode529 {

    private int[][] dirs = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1},
            {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    /**
     * Leetcode 1162 - As Far from Land as Possible (Medium)
     * TC: O(n ^ 2)
     * SC: O(n ^ 2)
     * Case 'M': flip to 'X' and return directly.
     * Case 'E':
     * (1) Add the click point to the queue and tag it visited.
     * (2) Breadth first search with the help of queue until the number of
     *     adjacent mines is not zero, keep adding adjacent grid to the queue
     *     otherwise.
     * (3) When no more grids can be revealed, return the board.
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        switch (board[click[0]][click[1]]) {
            case 'M':
                board[click[0]][click[1]] = 'X';
                return board;
            case 'E':
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{click[0], click[1]});
                visited[click[0]][click[1]] = true;
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int k = 0; k < size; k++) {
                        int[] cur = q.poll();
                        int i = cur[0], j = cur[1];
                        int digit = digit(board, i, j);
                        if (digit == 0) {
                            board[i][j] = 'B';
                            for (int d = 0; d < 8; d++) {
                                int x = i + dirs[d][0], y = j + dirs[d][1];
                                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length ||
                                        board[x][y] != 'E' || visited[x][y]) {
                                    continue;
                                }
                                visited[x][y] = true;
                                q.add(new int[]{x, y});
                            }
                        } else {
                            board[i][j] = (char) ('0' + digit);
                        }
                    }
                }
                break;
        }
        return board;
    }


    private int digit(char[][] board, int i, int j) {
        int digit = 0;
        for (int d = 0; d < 8; d++) {
            int x = i + dirs[d][0], y = j + dirs[d][1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'M') {
                continue;
            }
            digit++;
        }
        return digit;
    }
}
