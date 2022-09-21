import java.util.*;
/**
 * 09/19/2022
 */
public class Leetcode17 {
    /**
     * Leetcode 79 - Letter Combinations of a Phone Number (Medium)
     * TC: O(4 ^ n)
     * SC: O(4 ^ n)
     * Use a queue to store temporary string in combining numbers.
     * For each elements in the queue, if the length is less than given string,
     * add candidate characters to the current one and append it to the queue.
     * Finally, flush add elements from the queue to the list.
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        int count = digits.length();
        String[] candidate = new String[]{"", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> q = new LinkedList<>();
        q.add("");
        while (!q.isEmpty()) {
            if (count-- == 0) {
                break;
            }
            int key = digits.charAt(digits.length() - 1 - count) - '0';
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (char c : candidate[key].toCharArray()) {
                    q.add(cur + c);
                }
            }
        }
        res.addAll(q);
        return res;
    }
}
