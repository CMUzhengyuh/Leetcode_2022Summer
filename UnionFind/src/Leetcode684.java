/**
 * 07/26/2022
 */
public class Leetcode684 {

    private int[] parent = new int[0];

    private int[] res = new int[2];

    private void union(int i, int j) {
        int p1 = find(i), p2 = find(j);
        if (p1 == p2) {
            res[0] = i;
            res[1] = j;
            return;
        }
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
     * Leetcode 684 - Redundant Connection (Medium)
     * TC: O(n)
     * SC: O(n)
     * Utilize an array to store the result.
     * Update the result in union() when two input nodes share same parent.
     */
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return res;
    }
}
