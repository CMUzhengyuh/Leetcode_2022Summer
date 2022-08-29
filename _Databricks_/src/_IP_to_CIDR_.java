import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 751.
 */
public class _IP_to_CIDR_ {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> res = new ArrayList<>();
        // Start from current IP, convert it to 32-bit integer.
        int cur = toInteger(ip);
        while (n > 0) {
            // Get the number of trailing '0's so that we can limit the number
            // of '0's in the pattern to add.
            int maxBits = Integer.numberOfTrailingZeros(cur);
            // Initialize the number of trailing '0's as 0.
            int count = 0;
            // Greedy Search the maximum allowed trailing zeros:
            // (1) The count should not exceed n to cover every IP.
            // (2) The count should also not exceed original number of '0's
            while ((1 << count) < n && count < maxBits) {
                count++;
            }
            if ((1 << count) > n) {
                count--;
            }
            res.add(toString(cur, 32 - count));
            n -= (1 << count);
            cur += ((1 << count));
        }
        return res;
    }

    /**
     * Helper function that convert given number and range to CIDR format.
     */
    private String toString(int num, int range) {
        final int WORD_SIZE = 8;
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            sb.append(Integer.toString((num >> (i * WORD_SIZE)) & 255));
            sb.append(".");
        }
        sb.setLength(sb.length() - 1);
        sb.append("/");
        sb.append(Integer.toString(range));
        return sb.toString();
    }

    /**
     * Helper function that convert IP string to 32-bit integer.
     */
    private int toInteger(String ip) {
        String[] addr = ip.split("\\.");
        int sum = 0;
        for (int i = 0; i < addr.length; i++) {
            sum *= 256;
            sum += Integer.parseInt(addr[i]);
        }
        return sum;
    }

    /**
     * Databricks:
     * Given a list of firewall rules, such as
     *      [{"192.168.1.22/24": allow}, {"192.168.122.126/20": deny}, ...]
     * Write a function to determine if an IP is allowed to pass the firewall.
     */
    public boolean ipMatchCidr(String ip, String cidr) {
        // Divide the pattern into two parts: IP and pattern.
        String[] split = cidr.split("/");
        int pattern = split.length == 2 ? Integer.parseInt(split[1]) : 32;
        // Converted ip and cidr IP part to int to compare.
        int cidrValue = ipToInt(split[0]);
        int ipValue = ipToInt(ip);
        // Create the mask according to the pattern. Pay attention to overflow
        // when pattern is exactly 32 (2^32 > Integer.MAX_VALUE).
        int mask = pattern == 32 ? 0xffffffff : ((1 << pattern) - 1) << (32 - pattern);
        // Check if the integer after masking is equivalent.
        return (ipValue & mask) == (cidrValue & mask);
    }

    private int ipToInt(String ip) {
        String[] split = ip.split("\\.");
        if (split.length != 4)
            return -1;
        int res = 0;
        for (String s : split) {
            res = (res << 8) + Integer.parseInt(s);
        }
        return res;
    }

    public static void main(String[] args) {
        _IP_to_CIDR_ solution = new _IP_to_CIDR_();
        System.out.println(solution.ipMatchCidr("192.168.1.167", "192.168.1.22/24"));
    }
}
