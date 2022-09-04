import java.util.*;
/**
 * 06/17/2022
 */
public class Leetcode173 {
    /**
     * Leetcode 173 - Binary Search Tree Iterator (Medium)
     * In the constructor, inorder traverse the BST and form the list.
     * In next(), fetch the element according to the index.
     * In hasNext(), check if index is out of bound.
     */
    class BSTIterator {

        private List<Integer> inorder;

        private int index;

        public BSTIterator(TreeNode root) {
            inorder = new ArrayList<>();
            traverse(root);
            index = 0;
        }

        private void traverse(TreeNode cur) {
            if (cur == null) return;
            traverse(cur.left);
            inorder.add(cur.val);
            traverse(cur.right);
        }

        public int next() {
            return inorder.get(index++);
        }

        public boolean hasNext() {
            return index < inorder.size();
        }
    }
}
