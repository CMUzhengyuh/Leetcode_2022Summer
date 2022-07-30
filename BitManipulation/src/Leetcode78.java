import java.util.ArrayList;
import java.util.List;
/**
 * 07/29/2022
 */
public class Leetcode78 {
    /**
     * Leetcode 78 - Subsets (Medium)
     * TC: O(n * 2^n)
     * SC: O(n * 2^n)
     * The result includes 2^n lists, for each list, use a number with only one
     * '1' as a mask to determine whether add the current number to the list.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

}
