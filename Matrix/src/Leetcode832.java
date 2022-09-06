/**
 * 09/05/2022
 */
public class Leetcode832 {
    /**
     * Leetcode 832 - Flipping an Image (Easy)
     * TC: O(n)
     * SC: O(1)
     * Update image[i][j] with value of image[i][n - j - 1] for left half part.
     */
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j <= image[0].length / 2; j++) {
                if (j == image[0].length - j - 1) {
                    image[i][j] = 1 - image[i][j];
                    continue;
                }
                int temp = 1 - image[i][image[0].length - 1 - j];
                image[i][image[0].length - 1 - j] = 1 - image[i][j];
                image[i][j] = temp;
            }
        }
        return image;
    }
}
