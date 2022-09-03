/**
 * 09/03/2022
 */
public class Leetcode88 {
    /**
     * Leetcode 217 - Contains Duplicate (Easy)
     * TC: O(n + m)
     * SC: O(1)
     * Update the first array backwards and select the larger one by comparing
     * the number in two pointers in both arrays.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums2[p2] > nums1[p1]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
}
