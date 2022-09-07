import java.util.*;
/**
 * 09/06/2022
 */
public class Leetcode992 {
    /**
     * Leetcode 992 - Subarrays with K Different Integers (Hard)
     * TC: O(n)
     * SC: O(n)
     * Divide the whole problem with two sub-problem:
     * (1) Given an array and find out the numbers of sub-arrays with at most
     *     K different integers. This problem can be solved by two pointers
     *     start from left boundary and when the number of distinct integers
     *     is larger than K, narrow the window by moving the left pointer.
     *     The result can be written as F(n)
     * (2) Sub-arrays with exact K different integer f(n) = F(n) - F(n - 1).
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k) -
                subarraysWithAtMostKDistinct(nums, k - 1);
    }

    public int subarraysWithAtMostKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() == k + 1) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}
