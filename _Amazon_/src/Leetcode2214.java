/**
 * 09/30/2022
 */
public class Leetcode2214 {
    /**
     * Leetcode 2214 - Minimum Health to Beat Game (Medium)
     * TC: O(n)
     * SC: O(1)
     * Traverse the array and calculate the sum of health and maximum damage.
     * The health that we need to beat the game without armor is the sum + 1.
     * If the armor cannot protect maximum damage, minus the armor, otherwise
     * the maximum damage.
     */
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        int max = 0;
        for (int d : damage) {
            sum += (long) d;
            max = Math.max(d, max);
        }
        return sum + 1 - (armor > max ? max : armor);
    }
}
