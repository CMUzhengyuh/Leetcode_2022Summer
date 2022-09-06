/**
 * 09/05/2022
 */
public class Leetcode867 {
    /**
     * Leetcode 867 - Transpose Matrix (Easy)
     * TC: O(n)
     * SC: O(1)
     * Transpose the matrix by mapping matrix[i][j] to res[j][i].
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                res[j][i] = matrix[i][j];
        return res;
    }
}
