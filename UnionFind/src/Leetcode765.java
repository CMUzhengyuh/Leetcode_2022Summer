/**
 * 07/26/2022
 */
public class Leetcode765 {

    private int[] parent = new int[0];

    private void union(int i, int j) {
        int p1 = find(i), p2 = find(j);
        if (p1 > p2) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
        }
    }

    private int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    /**
     * Leetcode 765 - Couples Holding Hands (Medium)
     * TC: O(n)
     * SC: O(n)
     * Define couples in a group:
     * Couples within the group with size k need (k - 1) swaps to get seated.
     * In the primary array, persons from two couples are adjacent and there is
     * at least one swap within those two couples so they belong to same group.
     * Traverse the array and arrange them to groups, the couples whose group
     * number is not equal to their couple number means they should be swapped.
     */
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        parent = new int[n / 2];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < parent.length; i++) {
            union(row[2 * i] / 2, row[2 * i + 1] / 2);
        }
        int res = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i != parent[i]) res++;
        }
        return res;
    }
}
