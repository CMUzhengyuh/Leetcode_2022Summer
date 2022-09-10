/**
 * 09/09/2022
 */
public class Leetcode1143 {
    /**
     * Leetcode 1143 - Longest Common Subsequence (Medium)
     * TC: O(n * m)
     * SC: O(n * m)
     * 2D Dynamic Programming:
     * Dimension 1: [0, text1.length] represent the dimension of text1.
     * Dimension 2: [0, text2.length] represent the dimension of text2.
     * dp[i][j] represents the maximum length of common subsequence until i, j.
     * Status function:
     * (1) text1(i) == text2(j), dp[i][j] = dp[i - 1][j - 1] + 1.
     *     The number of common sequence increases as adding the new position.
     * (2) text1(i) != text2(j), dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]).
     *     The number of common sequence maintains the same as those two cases.
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char c = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                if (c == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
