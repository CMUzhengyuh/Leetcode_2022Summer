import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 311.
 */
public class _Product_Of_Sparse_Matrix_ {
    /**
     * Data structure to store sparse matrix.
     * cols and rows represents the dimension of matrix.
     */
    private class SparseMatrix {
        private int cols = 0, rows = 0;
        private List<Integer> val = new ArrayList<>();
        private List<Integer> col = new ArrayList<>();
        private List<Integer> row = new ArrayList<>();

        /**
         * Row-based storage:
         * col stores the column index of each non-zero elements in the matrix.
         * val stores corresponding values.
         * # row = rows + 1, row[i] stores the accumulative non-zeros in the
         * matrix[0] to matrix[i - 1].
         */
        public SparseMatrix(int[][] matrix) {
            rows = matrix.length;
            cols = matrix[0].length;
            row.add(0);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] != 0) {
                        val.add(matrix[i][j]);
                        col.add(j);
                    }
                }
                row.add(val.size());
            }
        }

        /**
         * Column-based storage.
         */
        public SparseMatrix(int[][] matrix, boolean isColumn) {
            rows = matrix.length;
            cols = matrix[0].length;
            col.add(0);
            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < rows; i++) {
                    if (matrix[i][j] != 0) {
                        val.add(matrix[i][j]);
                        row.add(i);
                    }
                }
                col.add(val.size());
            }
        }
    }

    public int[][] multiply(int[][] mat1, int[][] mat2) {
        SparseMatrix A = new SparseMatrix(mat1);
        SparseMatrix B = new SparseMatrix(mat2, true);
        int[][] res = new int[mat1.length][mat2[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                // Initialize the range of elements of A[i] and B[j].
                int rowStart = A.row.get(i), rowEnd = A.row.get(i + 1);
                int colStart = B.col.get(j), colEnd = B.col.get(j + 1);
                // Check if rowIndex == colIndex.
                while (rowStart < rowEnd && colStart < colEnd) {
                    if (A.col.get(rowStart) < B.row.get(colStart)) {
                        rowStart++;
                    } else if (A.col.get(rowStart) > B.row.get(colStart)) {
                        colStart++;
                    } else {
                        res[i][j] += A.val.get(rowStart++) * B.val.get(colStart++);
                    }
                }
            }
        }
        return res;
    }
}