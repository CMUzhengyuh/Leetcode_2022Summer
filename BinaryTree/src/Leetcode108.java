/**
 * 06/06/2022
 */
public class Leetcode108 {
    /**
     * Leetcode 108 - Convert Sorted Array to Binary Search Tree (Easy)
     * TC: O(n)
     * SC: O(logn)
     * (1) Generate the parent node based on the middle pointer.
     * (2) Recursively generate left and right child with updated intervals.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        return BSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode BSTHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = BSTHelper(nums, left, mid - 1);
        cur.right = BSTHelper(nums, mid + 1, right);
        return cur;
    }
}
