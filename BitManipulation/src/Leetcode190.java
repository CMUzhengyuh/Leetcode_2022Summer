/**
 * 07/28/2022
 */
public class Leetcode190 {
    /**
     * Leetcode 190 - Reverse Bits (Easy)
     * TC: O(1)
     * SC: O(1)
     * Divide and conquer with bit shifting:
     * Swap each 16 digits for each 32 digits first.
     * Swap each 8 digits for each 16 digits then and so on until each 2.
     */
    public int reverseBits(int num) {
        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
        return num;
    }
}
