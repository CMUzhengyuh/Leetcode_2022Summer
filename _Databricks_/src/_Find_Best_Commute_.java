import java.util.*;
public class _Find_Best_Commute_ {
    public static char findBestCommute(char[][] board, int[] timeCost, int[] moneyCost) {
        int m = board.length, n = board[0].length;
        int minTime = Integer.MAX_VALUE, minMoney = Integer.MAX_VALUE;
        int choices = timeCost.length;
        char res = '*';
        /**
         * Find the starting point and start BFS.
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'S') {
                    for (int k = 0; k < choices; k++) {
                        int time = timeCost[k], money = moneyCost[k];
                        char choice = (char) (k + '1');
                        int level = BFS(i, j, board, choice);
                        if (level == -1) {
                            continue;
                        }
                        // Compare time first and money if tied.
                        time *= level;
                        money *= level;
                        if (time < minTime) {
                            minTime = time;
                            res = choice;
                        } else if (time == minTime && money < minMoney) {
                            minMoney = money;
                            res = choice;
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * BFS starts from board[i][j] and fetch shortest path of given choice.
     */
    private static int BFS(int i, int j, char[][] board, char c) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int level = 0;

        visited[i][j] = true;
        q.add(new int[]{i, j});

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] pos = q.poll();
                int x = pos[0], y = pos[1];
                if (board[x][y] == 'D') {
                    return level;
                }
                for (int[] dir : dirs) {
                    int nextX = x + dir[0], nextY = y + dir[1];
                    // (1) Point within the board.
                    // (2) Point not visited.
                    // (3) Point shares same choice or reaches destination.
                    if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n
                            && !visited[nextX][nextY]
                            && (board[nextX][nextY] == c || board[nextX][nextY] == 'D')) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'3','3','S','2','X','X'},
                {'3','1','1','2','X','2'},
                {'3','1','1','2','2','2'},
                {'3','1','1','1','D','3'},
                {'3','3','3','3','3','4'},
                {'4','4','4','4','4','4'},
        };
        int[] timeCost = {3, 2, 1, 1};
        int[] moneyCost = {0, 1, 3, 2};
        System.out.println(findBestCommute(board, timeCost, moneyCost));
    }
}
