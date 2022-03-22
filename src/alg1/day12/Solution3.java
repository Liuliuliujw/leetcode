package alg1.day12;

import java.util.List;

/**
 * 120 三角形最小路径和
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(minimumTotal(List.of(List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3))));

        System.out.println(minimumTotal(List.of(List.of(-10))));
    }

    /**
     * 思路分析：
     * 到 triangle[i][j] 的最小路径和为：triangle[i][j] + min(triangle[i+1][j],triangle[i+1][j+1])
     * 利用动态规划的思想，我们可以自底向上计算到每一层各元素的最小路径和，直到顶点
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        if (h == 0) return 0;

        int[] ans = new int[triangle.get(h - 1).size() + 1]; //最底层长度 + 1
        List<Integer> curr;

        //自底向上搜索
        for (int i = h - 1; i >= 0; i--) {
            curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                //计算最小路径和
                ans[j] = curr.get(j) + Math.min(ans[j], ans[j + 1]);
            }
        }

        return ans[0];
    }

}
