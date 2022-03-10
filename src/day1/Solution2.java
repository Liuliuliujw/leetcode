package day1;

/**
 * 278 第一个错误版本
 *
 * @author llliujw
 */
public class Solution2 {
    public static int bad;

    public static void main(String[] args) {
        bad = 4;
        System.out.println(firstBadVersion(5));
    }

    /**
     * 利用二分查找收缩范围直至边界相等
     */
    public static int firstBadVersion(int n) {
        int l = 1, r = n, m;
        while (l < r) {
            m = l + ((r - l) >> 1); //位运算代替除法运算，不使用l+(r-l)/2而是(l+r)/2的原因是防止l+r的结果溢出
            if (isBadVersion(m))
                r = m; //r=m而非r=m-1是因为防止m是第一个bad版本的情况
            else
                l = m + 1;
        }
        return l;
    }

    public static boolean isBadVersion(int m) {
        return m >= bad;
    }
}
