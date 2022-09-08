import java.util.*;
/**
 * 09/07/2022
 */
public class Leetcode322 {
    /**
     * Leetcode 332 - Coin Change (Medium)
     * TC: O(n * amount)
     * SC: O(n)
     * 1D Dynamic Programming with fixed array length = amount + 1:
     * The value of each slots represents the minimum amounts of coins.
     * Loop through each amount and then each kinds of coins to check if
     * add one coins[j] can decrease the amount of coins to achieve i.
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
