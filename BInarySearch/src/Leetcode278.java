/**
 * 08/16/2022
 */
public class Leetcode278 {
    /**
     * Leetcode 278 - First Bad Version (Easy)
     * TC: O(nlogn)
     * SC: O(1)
     * Record the bad version when the API result is true and find the first.
     */
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1, right = n, res = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid)) {
                    right = mid - 1;
                    res = mid;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
          boolean isBadVersion(int version); */
    public class VersionControl {
        boolean isBadVersion(int version) {
            return true;
        }
    }
}
