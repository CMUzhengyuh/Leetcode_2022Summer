/**
 * 08/18/2022
 */
public class Leetcode74 {
    /**
     * Leetcode 74 - Search a 2D Matrix (Medium)
     * TC: O(log(mn))
     * SC: O(1)
     * In the first search, locate the row index through first column.
     * In the second search, check if the element exists in the specific row.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1, row = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                row = mid;
            }
        }
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
