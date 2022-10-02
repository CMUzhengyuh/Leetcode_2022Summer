import java.util.*;
/**
 * 10/02/2022
 */
public class Leetcode937 {
    /**
     * Leetcode 937 - Reorder Data in Log Files (Medium)
     * TC: O(nlogn)
     * SC: O(n)
     * Override the compare() function according to the reorder requirement.
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            int contentA = a.indexOf(" ") + 1;
            int contentB = b.indexOf(" ") + 1;
            boolean isLetterA = Character.isLetter(a.charAt(contentA));
            boolean isLetterB = Character.isLetter(b.charAt(contentB));
            if (isLetterA && isLetterB) {
                int cmp = a.substring(contentA).compareTo(b.substring(contentB));
                if (cmp != 0) {
                    return cmp;
                }
                return a.compareTo(b);
            } else if (isLetterA && !isLetterB) {
                return -1;
            } else if (!isLetterA && isLetterB) {
                return 1;
            } else {
                return 0;
            }
        });
        return logs;
    }
}
