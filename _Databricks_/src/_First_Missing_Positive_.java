/**
 * Leetcode 41.
 */
public class _First_Missing_Positive_ {
    public int firstMissingPositive(int[] nums) {
        // Swap num[i] with num[num[i] - 1] to place number to right index.
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // Scan the array to find the first absent positive.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)    return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
