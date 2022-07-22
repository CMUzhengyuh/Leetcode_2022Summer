/**
 * 07/21/2022
 */
public class Leetcode547 {

    private int[] province = new int[0];

    private int res = 0;

    private void union(int i, int j) {
        int p = find(i), q = find(j);
        if (p == q) return;
        res--;
        if (p < q) province[q] = p;
        else province[p] = q;
    }

    private int find(int index) {
        int i = index;
        while (i != province[i]) {
            i = province[i];
        }
        province[index] = i;
        return i;
    }

    /**
     * Leetcode 547 - Number of Provinces (Medium)
     * TC: O(n)
     * SC: O(n)
     * Share the same idea with Leetcode 200.
     * Union two provinces if the pair is connected.
     */
    public int findCircleNum(int[][] isConnected) {
        province = new int[isConnected.length];
        res = isConnected.length;
        for (int i = 0; i < province.length; i++) {
            province[i] = i;
        }
        for (int i = 0; i < province.length; i++) {
            for (int j = i + 1; j < province.length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return res;
    }
}
