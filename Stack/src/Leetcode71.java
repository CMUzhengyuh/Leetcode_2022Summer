import java.util.*;
/**
 * 06/26/2022
 */
public class Leetcode71 {
    /**
     * Leetcode 71 - Simplify Path (Medium)
     * TC: O(n)
     * SC: O(n)
     * Use a string stack to record relative paths:
     * (1) Split the string with "/" so that "//" can be excluded.
     * (2) Pop current top to represent ".." and push valid elements.
     * (3) Rejoin the elements in stack to form the simplify path.
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        for (int i = 0; i < p.length; i++) {
            if (!stack.empty() && p[i].equals(".."))
                stack.pop();
            else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        List<String> list = new ArrayList(stack);
        return "/" + String.join("/", list);
    }
}
