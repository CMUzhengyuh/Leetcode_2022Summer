/**
 * 09/27/2022
 */
public class Leetcode31 {
    /**
     * Leetcode 31 - Next Permutation (Medium)
     * TC: O(n)
     * SC: O(1)
     * (1) Find backwards until nums[i] > nums[i + 1], save the position as j.
     * (2) Find backwards until nums[j] > nums[i] and swap(i, j).
     * (3) Swap all the pairs in the interval [j + 1, n].
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int index = nums.length - 1;
        while (index > 0 && nums[index - 1] >= nums[index]) {
            index--;
        }
        if (index == 0) {
            for (int i = 0; i < nums.length / 2; i++) {
                swap(nums, i, nums.length - i - 1);
            }
            return;
        }
        int temp = index - 1;
        index = nums.length - 1;
        while (nums[index] <= nums[temp]) {
            index--;
        }
        swap(nums, index, temp);
        for (int i = temp + 1; i <= (temp + nums.length) / 2; i++) {
            swap(nums, i, nums.length + temp - i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
