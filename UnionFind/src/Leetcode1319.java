/**
 * 07/24/2022
 */
public class Leetcode1319 {

    private int[] parent = new int[0];

    private int parts;

    public void union(int i, int j) {
        int p1 = find(i), p2 = find(j);
        if (p1 > p2) {
            parent[p1] = p2;
            parts--;
        } else if (p1 < p2) {
            parent[p2] = p1;
            parts--;
        }
    }

    public int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    /**
     * Leetcode 1319 - Number of Operations to Make Network Connected (Medium)
     * TC: O(n)
     * SC: O(n)
     * Union the nodes that is connected, then calculate cables = # parts - 1.
     * Pay attention to cases that cables may not be enough.
     */
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        parts = n;
        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }
        return parts - 1;
    }

    /**
     * Corner Case: NOT ENOUGH CABLESao
     */

}
