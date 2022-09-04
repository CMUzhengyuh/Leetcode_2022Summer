/**
 * 09/03/2022
 */
public class Leetcode781 {
    /**
     * Leetcode 781 - Rabbits in Forest (Medium)
     * TC: O(n)
     * SC: O(n)
     * Create an array to store the count of possible pairs of rabbits.
     * (1) Considering an answer of k, update the k + 1 slot including itself.
     * (2) Traverse the array for each slot and the overall count for given
     *     index i should be i * (floor(map[i] / i) + 1).
     */
    public int numRabbits(int[] answers) {
        int[] map = new int[1001];
        for (int answer : answers) {
            map[answer + 1]++;
        }
        int res = 0;
        for (int i = 1; i < map.length; i++) {
            if (map[i] == 0) {
                continue;
            }
            if (map[i] <= i) {
                res += i;
            } else {
                res += i * (((map[i] + i - 1) / i));
            }
        }
        return res;
    }
}
