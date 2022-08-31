import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Leetcode 1861.
 */
public class _Rotate_Box_ {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];
        for (int j = 0; j < n; j++) {
            Arrays.fill(res[j], '.');
        }
        /**
         * obs: List<list> that stores the obstacle information with row index.
         * list: List<int[]> that stores obstacle position and stone numbers.
         */
        List<List<int[]>> obs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<int[]> list = new ArrayList<>();
            int[] cur = new int[]{-1, 0};
            for (int j = 0; j < n; j++) {
                switch (box[i][j]) {
                    // Stone: add the number of stones.
                    case '#':
                        cur[1]++;
                        break;
                    // Obstacle:
                    // (1) Update the current obstacle to the list.
                    // (2) Create a new temporary array to store data.
                    case '*':
                        list.add(new int[]{j, cur[1]});
                        cur = new int[]{i, 0};
                        break;
                }
            }
            // The bottom is also considered as an obstacle.
            list.add(new int[]{n, cur[1]});
            // Wrap current list to the larger list.
            obs.add(new ArrayList<>(list));
        }
        /**
         * Coordinate conversion: box[i][j] -> res[j][m - 1 - i]
         */
        for (int i = 0; i < m; i++) {
            List<int[]> list = obs.get(i);
            for (int[] cur : list) {
                for (int j = 0; j <= cur[1]; j++) {
                    // Obstacle in the middle.
                    if (j == 0 && cur[0] != n) {
                        res[cur[0] - j][m - 1 - i] = '*';
                    }
                    // Add stones according to the number.
                    if (j != 0) {
                        res[cur[0] - j][m - 1 - i] = '#';
                    }
                }
            }
        }
        return res;
    }
}