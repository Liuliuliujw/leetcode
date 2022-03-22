package stru1.day1;

/**
 * 53. 最大子数组和
 * <p>
 * 这题用动态规划的效率较高，之所以归于数据结构是因为他的分治解法的逻辑可以抽取出来建立一种重复查询只需要O(logn)的结构：线段树
 * 详见该题官方题解中的 [题外话] 部分
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    /**
     * 对maxSubArray1的优化： 以nums[i]结尾的最大子序和只和以nums[i-1]结尾的最大子序和有关
     * 我们只需要记录以num[i-1]结尾的最大子序和 以及 到第i项的最大子序和
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;//以num[i-1]结尾的最大子序和
        int res = nums[0];//到第i项的最大子序和 （并非以num[i]结尾的子序和）
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }

    /**
     * 动态规划
     * <p>
     * 以nums[i]结尾的最大子序和为nums[i] 或 nums[i]+以nums[i-1]结尾的最大子序和
     */
    public static int maxSubArray1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];// dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int max = dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
