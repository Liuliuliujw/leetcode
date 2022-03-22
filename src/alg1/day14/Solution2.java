package alg1.day14;

/**
 * 136. 只出现一次的数字
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    /**
     * 利用位运算 n ^ n = 0 的性质消除成对出现的数字
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
