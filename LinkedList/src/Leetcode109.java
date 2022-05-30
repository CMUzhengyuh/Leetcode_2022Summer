/**
 * 05/29/2022
 */
public class Leetcode109 {

    private ListNode cur;

    /**
     * Leetcode 109 - Convert Sorted List to Binary Search Tree (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) Find out the size of linked list (BST)
     * (2) Recursively generate the balanced BST with the help of cur pointer
     */
    public TreeNode sortedListToBST(ListNode head) {
        int size;
        cur = head;
        size = getLength(head);
        return listToBST(size);
    }

    private int getLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private TreeNode listToBST(int size) {
        if (size <= 0) return null;
        TreeNode left = listToBST(size / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = listToBST(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
    }

    /**
     * BST Node Class
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


