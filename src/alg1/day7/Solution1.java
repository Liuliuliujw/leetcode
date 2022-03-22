package alg1.day7;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 733 图像渲染
 *
 * @author llliujw
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] image1 = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}};
        print(floodFill(image1, 1, 1, 2));

        int[][] image2 = new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}};
        print(floodFill(image2, 0, 0, 2));
    }

    //递归实现DFS
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private static void helper(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != oldColor || newColor == oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        helper(image, sr - 1, sc, newColor, oldColor);
        helper(image, sr + 1, sc, newColor, oldColor);
        helper(image, sr, sc - 1, newColor, oldColor);
        helper(image, sr, sc + 1, newColor, oldColor);
    }

    private static void print(int[][] src) {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int[] ints : src) {
            sj.add(Arrays.toString(ints));
        }
        System.out.println(sj);
    }
}
