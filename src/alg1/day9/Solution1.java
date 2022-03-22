package alg1.day9;

import java.util.*;

/**
 * 542 01 矩阵
 *
 * @author llliujw
 */
public class Solution1 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int[][] mat1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        print(updateMatrix(mat1));

        int[][] mat2 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        print(updateMatrix(mat2));
    }

    /**
     * 官方题解二 ==> 动态规划？
     * ‘1’到‘0’的距离为这个‘1’的邻居到‘0’的距离加一
     * 从‘1’到‘0’的路径中，只需要两步（水平移动和竖直移动）
     */
    public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化动态规划的数组，所有的距离值都设置为一个很大的数，超过最大距离
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }
        // 如果 (i, j) 的元素为 0，那么距离为 0
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        // 从矩阵的左上开始 ，这样可以保证左邻居和上邻居是已遍历的
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1); //左邻居比较
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1); //上邻居比较
                }
            }
        }
        // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        // 从矩阵的右下开始
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i + 1 < m) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);//右邻居比较
                }
                if (j + 1 < n) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1); //下邻居比较
                }
            }
        }
        return dist;
    }

    /**
     * leetcode题解方法一 ==> updateMatrix1 的改进：
     * 将 updateMatrix1 中以‘1’为源点改为 以‘0’为源点，但此时题目中存在多个‘0’，
     * 我们可以引入一个超级零(超级源点)指向所有零，这样‘1’到‘0’的最短路径就是 到超级零的距离减一（将多源点问题转化为单源点问题）
     */
    public static int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n]; //输出矩阵
        boolean[][] seen = new boolean[m][n]; //记录已搜索的点
        Queue<int[]> queue = new LinkedList<>(); //超级源点
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }
        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return dist;
    }

    /**
     * 依次遍历，通过bfs计算每个1到0的最短距离
     * 由于需要依次遍历，多次计算，时间复杂度依旧很高
     */
    public static int[][] updateMatrix1(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                ans[i][j] = bfs1(mat, i, j);
            }
        }
        return ans;
    }

    private static int bfs1(int[][] mat, int i, int j) {
        if (mat[i][j] == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                if (mat[curr[0]][curr[1]] == 0) return count;
                if (curr[0] + 1 < mat.length) queue.offer(new int[]{curr[0] + 1, curr[1]});
                if (curr[1] + 1 < mat[0].length) queue.offer(new int[]{curr[0], curr[1] + 1});
                if (curr[0] - 1 >= 0) queue.offer(new int[]{curr[0] - 1, curr[1]});
                if (curr[1] - 1 >= 0) queue.offer(new int[]{curr[0], curr[1] - 1});
            }
            count++;
        }
        return count;
    }

    private static void print(int[][] src) {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int[] ints : src) {
            sj.add(Arrays.toString(ints));
        }
        System.out.println(sj);
    }
}
