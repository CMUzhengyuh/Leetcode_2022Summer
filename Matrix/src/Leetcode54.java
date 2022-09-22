import java.util.*;
/**
 * 09/21/2022
 */
public class Leetcode54 {
    /**
     * Leetcode 54 - Spiral Matrix (Medium)
     * TC: O(m * n)
     * SC: O(m * n)
     * Traverse the matrix layer by layer. First tag all the vertex and divide
     * the traversal of each layer into four one-way horizontal and vertical
     * movement until the size reaches the number of matrix elements
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;
        while (res.size() < n * m) {
            for (int j = left; j <= right && res.size() < n * m; j++) {
                res.add(matrix[up][j]);
            }
            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++) {
                res.add(matrix[i][right]);
            }
            for (int j = right; j >= left && res.size() < n * m; j--) {
                res.add(matrix[down][j]);
            }
            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
