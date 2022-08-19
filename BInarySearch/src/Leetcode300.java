/**
 * 08/18/2022
 */
public class Leetcode300 {
    /**
     * Leetcode 300 - Longest Increasing Subsequence (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * This solution is based on the requirement that we only need the length:
     * Utilize an array during the traversal and temp[i] means that when the
     * size of an increasing subsequence is i + 1, the smallest possible number
     * of this subsequence is temp[i].
     * During the traversal, when the new number is larger than current maximum
     * size, we can directly add it to the last position in temp[size] and add
     * the size. Else, we can update the index from 0 to size - 1 in O(logn)
     * time complexity via binary search.
     */
    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            temp[left] = num;
            if (left == size) size++;
        }
        return size;
    }
}
