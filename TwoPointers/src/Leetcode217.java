import java.util.*;
/**
 * 09/03/2022
 */
public class Leetcode217 {
    /**
     * Leetcode 217 - Contains Duplicate (Easy)
     * TC: O(n)
     * SC: O(n)
     * HashSet to store existed number and check duplicates.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }
}
