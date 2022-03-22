package alg1.day7;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 695 岛屿的最大面积
 *
 * @author llliujw
 */
public class Solution2 {
    public static void main(String[] args) {
        int[][] grid1 = new int[][]{new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid1));

        int[][] grid2 = new int[][]{new int[]{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid2));
    }

    /**
     * 图的遍历
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) maxArea = Math.max(maxArea, countByDfs(grid, i, j));
            }
        }
        return maxArea;
    }

    /**
     * 基于递归的深度优先，最快 --100%
     */
    private static int countByDfs(int[][] grid, int cur_i, int cur_j) {
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] == 0) {
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int ans = 1;
        ans += countByDfs(grid, cur_i + 1, cur_j);
        ans += countByDfs(grid, cur_i - 1, cur_j);
        ans += countByDfs(grid, cur_i, cur_j + 1);
        ans += countByDfs(grid, cur_i, cur_j - 1);
        return ans;
    }

    /**
     * 我的答案：利用队列实现广度优先，为避免重复访问，访问过的节点置零
     */
    private static int countByBfs1(int[][] target, int i, int j) {
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        int[] curr;
        while ((curr = queue.poll()) != null) {
            if (target[curr[0]][curr[1]] == 0) continue;
            count++;
            target[curr[0]][curr[1]] = 0; //当前节点置零，避免重复
            if (curr[0] - 1 >= 0) queue.offer(new int[]{curr[0] - 1, curr[1]}); //上
            if (curr[0] + 1 < target.length) queue.offer(new int[]{curr[0] + 1, curr[1]}); //下
            if (curr[1] - 1 >= 0) queue.offer(new int[]{curr[0], curr[1] - 1}); //左
            if (curr[1] + 1 < target[curr[0]].length) queue.offer(new int[]{curr[0], curr[1] + 1}); //右
        }
        return count;
    }

    /**
     * 队列实现广度优先的第一种解法
     */
    private static int countByBfs2(int[][] target, int i, int j) {
        int count = 0;
        Queue<Integer> queue_i = new LinkedList<>();
        Queue<Integer> queue_j = new LinkedList<>();
        queue_i.offer(i);
        queue_j.offer(j);
        int curr_i;
        int curr_j;
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        while (!queue_i.isEmpty() && !queue_j.isEmpty()) {
            curr_i = queue_i.poll();
            curr_j = queue_j.poll();
            if (target[curr_i][curr_j] == 0) continue;
            count++;
            target[curr_i][curr_j] = 0; //当前节点置零，避免重复
            for (int index = 0; index != 4; ++index) {
                int next_i = curr_i + di[index], next_j = curr_j + dj[index];
                if (next_i >= 0 && next_i < target.length && next_j >= 0 && next_j < target[0].length) {
                    queue_i.offer(next_i);
                    queue_j.offer(next_j);
                }
            }
        }
        return count;
    }
}
