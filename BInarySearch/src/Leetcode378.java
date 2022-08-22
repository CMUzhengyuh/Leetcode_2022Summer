/**
 * 08/21/2022
 */
public class Leetcode378 {
    /**
     * Leetcode 378 - Kth Smallest Element in a Sorted Matrix (Medium)
     * TC: O(nlogn)
     * SC: O(1)
     * The answer lies within matrix[0][0] and matrix[n - 1][n - 1] and we can
     * binary search the result. For each mid value, we can count the number of
     * elements smaller than mid with a traversal from rightmost element of the
     * first row to leftmost element of the last row with O(n) time complexity.
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, res = 0;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = n, row = 0, col = n - 1;
            while (row < n) {
                while (col >= 0 && matrix[row][col] > mid) {
                    col--;
                }
                row++;
                count += col;
            }
            if (count >= k) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
