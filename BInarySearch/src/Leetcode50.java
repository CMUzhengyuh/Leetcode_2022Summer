/**
 * 08/19/2022
 */
public class Leetcode50 {
    /**
     * Leetcode 50 - Pow(x, n) (Medium)
     * TC: O(logn)
     * SC: O(logn)
     * Recursively decrease the absolute value of n via Pow(x ^ 2, n / 2).
     * Consider whether n is odd or even to add the coefficient.
     */
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) return 1.0;
        if (n == 1) return x;
        if (n < 0) return (1 / x) * 1 / myPow(x, -(n + 1));
        return myPow(x * x, n / 2) * (n % 2 == 0 ? 1 : x);
    }
}
