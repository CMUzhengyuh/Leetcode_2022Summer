import java.util.*;
/**
 * 06/04/2022
 */
public class Leetcode144 {

    private List<Integer> list;

    /**
     * Leetcode 144 - Binary Tree Preorder Traversal (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursive traversal: parent -> left -> right.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    private void traverse(TreeNode cur) {
        if (cur == null) return;
        list.add(cur.val);
        traverse(cur.left);
        traverse(cur.right);
    }

    /**
     * Iterative implementation
     */
    public List<Integer> iterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.add(p.val);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }
}