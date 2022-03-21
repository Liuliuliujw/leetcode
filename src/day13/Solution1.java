package day13;

/**
 * 231. 2的幂
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {
        // n 若为2的幂次 则n和n-1按位与的结果为全0
        return n > 0 && (n & (n - 1)) == 0;
        // 计算机中用补码存储负数，即正数二进制取反加一
        //return n > 0 && (n & -n) == n;
    }
}
