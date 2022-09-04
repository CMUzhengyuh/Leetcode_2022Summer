import java.util.*;
/**
 * 07/18/2022
 */
public class Leetcode378 {
    /**
     * Leetcode 378 - Kth Smallest Element in a Sorted Matrix (Medium)
     * TC: O(n^2)
     * SC: O(n)
     * *** Heap method is not optimal.
     * Traverse the whole matrix and add elements to max-Heap if needed.
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pq.size() == k) {
                    if (pq.peek() > matrix[i][j]) {
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                } else {
                    pq.add(matrix[i][j]);
                }
            }
        }
        return pq.peek();
    }
}
