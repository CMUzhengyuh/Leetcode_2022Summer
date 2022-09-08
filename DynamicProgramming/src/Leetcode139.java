import java.util.*;
/**
 * 09/07/2022
 */
public class Leetcode139 {
    /**
     * Leetcode 139 - Word Break (Medium)
     * TC: O(n ^ 3)
     * SC: O(n)
     * 1D Dynamic Programming with fixed array length = len(S) + 1:
     * For a given slot with index i, if the value if false, it means the
     * substring(0, i) cannot form by word dictionary. Loop through the
     * string length and find out:
     * (1) If current position is unreachable, skip current position.
     * (2) Try to find following substring with length = l. If it exists,
     *     update corresponding boolean value.
     * If the last position is reachable, return true and false otherwise.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] canReach = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String str : wordDict) {
            set.add(str);
        }
        canReach[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            if (!canReach[i]) {
                continue;
            }
            for (int l = 0; l <= s.length() - i; l++) {
                if (canReach[i + l]) {
                    continue;
                }
                String str = s.substring(i, i + l);
                if (set.contains(str)) {
                    canReach[i + l] = true;
                }
            }
        }
        return canReach[s.length()];
    }
}
