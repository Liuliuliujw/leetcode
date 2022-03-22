package alg1.day13;

/**
 * 191. 位1的个数
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(-3));
    }

    /**
     * 对 hammingWeight1 位运算解法的优化
     * 利用 n&(n-1) 可以将最低位的1反转为0 的性质，依次反转二进制串中的1
     * 平均时间复杂度 O(logk)
     * 空间复杂度 O(1)
     */
    public static int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= n - 1;
            ans++;
        }
        return ans;
    }

    /**
     * 利用位运算依次获取32为二进制数，并统计
     * 时间复杂度 O(k) , k为整数二进制位数
     * 空间复杂度 O(1)
     */
    public static int hammingWeight1(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (n << 31 != 0) ans++;
            n = n >> 1;
            //两者思想相同
            //if ((n & (1 << i)) != 0) ans++;
        }
        return ans;
    }
}
