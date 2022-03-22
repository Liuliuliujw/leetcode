package alg1.day9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994 腐烂的橘子
 *
 * @author llliujw
 */
public class Solution2 {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid1));

        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(grid2));

        int[][] grid3 = {{0, 2}};
        System.out.println(orangesRotting(grid3));
    }

    /**
     * Java 多源BFS 1ms 100%
     */
    public static int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length; //行数和列数
        Queue<int[]> queue = new LinkedList<>(); //队列，存放将要腐烂的橘子
        boolean[][] seen = new boolean[m][n]; //记录矩阵中的已阅的元素
        int cnt = 0; //未腐烂橘子个数
        for (int i = 0; i < m; i++) { //将所有的‘0’和‘2’设为已阅，并将所有的‘2’入队，并计算未腐烂橘子个数（当前时间为-1分钟）
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                    cnt++;
                } else if (grid[i][j] == 1) {
                    cnt++;
                } else if (grid[i][j] == 0) {
                    seen[i][j] = true;
                }
            }
        }

        if (cnt == 0) return 0; //没有橘子时，返回0

        //bfs
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = -1; //时间
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                grid[curr[0]][curr[1]] = 2;
                cnt--; //腐烂后，个数减一
                for (int d = 0; d < 4; ++d) {
                    int ni = curr[0] + dirs[d][0];
                    int nj = curr[1] + dirs[d][1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                        queue.offer(new int[]{ni, nj});
                        seen[ni][nj] = true;
                    }
                }
            }
            time++;
        }

        if (cnt > 0) return -1; //还有橘子未腐烂时返回-1

        return time;
    }
}
