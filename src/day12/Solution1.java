package day12;

/**
 * 70 爬楼梯
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }

    /**
     * 动态规划对斐波那契递归的优化，只存储上两个值
     */
    public static int climbStairs(int n) {
        if (n <= 1) return 1;
        int last = 1, nextToLast = 1, ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = last + nextToLast;
            nextToLast = last;
            last = ans;
        }
        return ans;
    }

    /**
     * 到第n阶楼梯的方案等于到第n-1阶和第n-2阶的和，这就等价一个斐波那契数列
     */
    public static int climbStairs1(int n) {
        if (n <= 1) return 1;
        else return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
