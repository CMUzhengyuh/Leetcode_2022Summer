import java.util.*;
/**
 * 06/04/2022
 */
public class Leetcode145 {

    private List<Integer> list;

    /**
     * Leetcode 145 - Binary Tree Postorder Traversal (Easy)
     * TC: O(n)
     * SC: O(n)
     * Recursive traversal: left -> right -> parent.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }

    private void traverse(TreeNode cur) {
        if (cur == null) return;
        traverse(cur.left);
        traverse(cur.right);
        list.add(cur.val);
    }

    /**
     * Iterative implementation
     */
    public List<Integer> iterative(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return result;
    }
}
