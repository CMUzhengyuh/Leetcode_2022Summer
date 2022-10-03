import java.util.*;
/**
 * 10/03/2022
 */
public class Leetcode767 {
    /**
     * Leetcode 767 - Reorganize String (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * (1) Collect the frequency of each lowercase letter in the string.
     * (2) If the highest frequency is larger than a half of string length + 1,
     *     it is impossible to give a reorganize scheme.
     * (3) Use a PriorityQueue that arranges according to the frequency of each
     *     character (descending) and use a variable to record last character
     *     appended, consider the top elements in the queue first. If it was
     *     just appended, add the second top.
     * (4) Repeat until the string is fulfilled.
     */
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq[b] - freq[a]);
        int max = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            max = Math.max(max, ++freq[s.charAt(i) - 'a']);
        }
        if (max > (n + 1) / 2) {
            return "";
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                pq.add(i);
            }
        }
        int prev = -1;
        while (n-- > 0) {
            int top = pq.poll();
            if (prev != top) {
                sb.append((char) ('a' + top));
                prev = top;
                if (freq[top]-- > 0) {
                    pq.add(top);
                }
            } else {
                int second = pq.poll();
                sb.append((char) ('a' + second));
                prev = second;
                if (freq[second]-- > 0) {
                    pq.add(second);
                }
                pq.add(top);
            }
        }
        return sb.toString();
    }
}
