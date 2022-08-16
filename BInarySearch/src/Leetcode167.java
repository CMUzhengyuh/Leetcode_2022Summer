/**
 * 08/16/2022
 */
public class Leetcode167 {
    /**
     * Leetcode 167 - Two Sum II - Input Array Is Sorted (Easy)
     * TC: O(nlogn)
     * SC: O(1)
     * Fix smaller number and find the bigger one within (i, nums.length - 1].
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target - nums[i]) {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                }
                if (nums[mid] < target - nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return res;
    }
}
