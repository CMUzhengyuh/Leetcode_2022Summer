import java.util.*;
/**
 * 08/16/2022
 */
public class Leetcode349 {
    /**
     * Leetcode 349 - Intersection of Two Arrays (Easy)
     * TC: O(n)
     * SC: O(n)
     * The binary search solution is to sort one array, traverse another and
     * check if the element exists in the sorted one, then record the existing
     * one to the HashSet. Finally, generate the result according to the set.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(), res = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        int[] nums = new int[res.size()];
        int index = 0;
        for (Integer i : res) {
            nums[index++] = i;
        }
        return nums;
    }


}
