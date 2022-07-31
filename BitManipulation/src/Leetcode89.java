import java.util.ArrayList;
import java.util.List;
/**
 * 07/30/2022
 */
public class Leetcode89 {
    /**
     * Leetcode 89 - Gray Code (Medium)
     * TC: O(2^n)
     * SC: O(2^n)
     * Gray Code = B(i) XOR B(i >> 1) where B(n) represents the binary format.
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < (1 << n); i++) {
            list.add(i ^ (i >> 1));
        }
        return list;
    }
}
