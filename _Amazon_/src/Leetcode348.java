/**
 * 10/03/2022
 */
public class Leetcode348 {
    /**
     * Leetcode 348 - Design Tic-Tac-Toe (Medium)
     * Use two arrays to record the sum of each rows and columns and two extra
     * integers to record the sum of main and sub diagonal.
     * Every time a new move is made, mark the player of 1 and 2 as 1 and -1 so
     * that when the records before reaches +n or -n, it means someone wins.
     */
    class TicTacToe {

        private int[] rows;

        private int[] cols;

        private int mainDiag;

        private int subDiag;

        private int size;

        public TicTacToe(int n) {
            this.rows = new int[n];
            this.cols = new int[n];
            this.size = 0;
        }

        public int move(int row, int col, int player) {
            int val = player == 1 ? 1 : -1;
            rows[row] += val;
            cols[col] += val;
            if (row == col) {
                mainDiag += val;
            }
            if (col == (cols.length - row - 1)) {
                subDiag += val;
            }
            if (Math.abs(rows[row]) == size ||
                    Math.abs(cols[col]) == size ||
                    Math.abs(mainDiag) == size ||
                    Math.abs(subDiag) == size) {
                return player;
            }

            return 0;
        }
    }

}
