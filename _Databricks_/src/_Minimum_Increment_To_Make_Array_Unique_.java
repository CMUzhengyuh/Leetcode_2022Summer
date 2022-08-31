/**
 * Leetcode 945.
 */
public class _Minimum_Increment_To_Make_Array_Unique_ {
    public int minIncrementForUnique(int[] A) {
        int [] arr = new int[100001];
        int ans = 0;
        // Count current number of elements with given value.
        for (int i : A) {
            arr[i]++;
        }
        for (int i = 1; i < 100001; i++) {
            // Existed elements: keep one and increase the rest (if have).
            if (arr[i - 1] != 0) {
                arr[i] += arr[i - 1] - 1;
                // Need #(currentCount - 1) increments..
                ans += arr[i - 1] - 1;
            }
        }
        /**
         * Arithmetic progression with difference = 1:
         * S = n * a_1 + n * (n - 1) d^2 / 2.
         */
        if (arr[arr.length - 1] != 0) {
            ans += arr[arr.length - 1] * (arr[arr.length - 1] - 1) / 2;
        }
        return ans;
    }
}