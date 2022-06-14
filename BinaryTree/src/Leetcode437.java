import java.util.HashMap;
import java.util.Map;

/**
 * 06/13/2022
 */
public class Leetcode437 {

    private int count;

    private int target;

    private Map<Integer, Integer> map;

    /**
     * Leetcode 437 - Path Sum III (Medium)
     * TC: O(n)
     * SC: O(n）
     * Use HashMap to record (prefix sum, count) mapping.
     * Update result when target sum and prefix sum equal to current sum.
     */
    public int pathSum(TreeNode root, int sum) {
        count = 0;
        target = sum;
        map = new HashMap<>();
        DFS(root, 0);
        return count;
    }

    public void DFS(TreeNode node, int currSum) {
        if (node == null) {
            return;
        }
        currSum += node.val;
        if (currSum == target) {
            count++;
        }
        count += map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        DFS(node.left, currSum);
        DFS(node.right, currSum);
        map.put(currSum, map.get(currSum) - 1);
    }
}