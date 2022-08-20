/**
 * 08/19/2022
 */
public class Leetcode240 {
    /**
     * Leetcode 240 - Search a 2D Matrix II (Medium)
     * TC: O(m + n)
     * SC: O(1)
     * Search from the leftmost of last row or rightmost of the first row.
     * Take starting from the rightmost node of the first row as an example:
     * (1) If the value hit the target, return true.
     * (2) If the value is smaller than the target, go downwards in that
     *     elements smaller than target should be on the right or down of
     *     current one.
     * (3) If the value is larger than the target, go leftwards.
     * (4) Continue until reach the leftmost node of the last row.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
