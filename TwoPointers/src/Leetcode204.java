/**
 * 09/03/2022
 */
public class Leetcode204 {
    /**
     * Leetcode 204 - Count Primes (Medium)
     * TC: O(Sqrt(n) * loglogn)
     * SC: O(n)
     * Use a boolean array with size = n to update the prime:
     * When a prime p is accessed, update the position within [p ^ 2, n] as
     * non-prime, the starting point is p ^ 2 in that other multiple of p
     * smaller than this is already updated before reaching p.
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int res = 0;
        boolean[] num = new boolean[n];
        for (int p = 2; p <= (int) Math.sqrt(n); p++) {
            if (num[p]) {
                continue;
            }
            for (int i = p * p; i < n; i += p) {
                num[i] = true;
            }
        }
        for (int i = 2; i < n; i++) {
            res += num[i] ? 0 : 1;
        }
        return res;
    }
}
