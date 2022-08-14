import java.util.Stack;
/**
 * 08/13/2022
 */
public class Leetcode316 {
    /**
     * Leetcode 316 - Daily Temperatures (Medium)
     * TC: O(n)
     * SC: O(n)
     * (1) Traverse the string and record the frequency of each character.
     * (2) Traverse again and maintain the monotonic increasing stack, reset
     *     the visited array so that visited character can be skipped.
     * (3) Rebuild the result by popping out the stack and reverse the string.
     */
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        char[] ch = s.toCharArray();
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char c : ch) {
            count[c - 'a']++;
        }
        for (char c : ch) {
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
