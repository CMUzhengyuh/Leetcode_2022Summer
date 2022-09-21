import java.util.*;
/**
 * 09/20/2022
 */
public class Leetcode79 {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * Leetcode 79 - Word Search (Medium)
     * TC: O(n * 3 ^ l), l = length of word
     * SC: O(l), l = length of word
     * Use a boolean to save visited grid during the traversal.
     * Traverse the whole board and find if any word matches the starting
     * character of given word. Then start to depth first search from the point
     * to check if the following character also matches, if matches continue,
     * otherwise return false. Repeat this process until all matches.
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && DFS(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean DFS(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (++index == word.length()) {
            return true;
        }
        boolean res = false;
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int x = i + dirs[d][0], y = j + dirs[d][1];
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index) || visited[x][y]) {
                continue;
            }
            res |= DFS(board, word, x, y, index, visited);
        }
        visited[i][j] = false;
        return res;
    }
}
