package day12;

/**
 * 198 打家劫舍
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    /**
     * 思路分析：
     * 不能连续访问，要想第n家利益最大，则要在第n-2或n-3利益最大，（n-4 => n-2-2）
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static int rob(int[] nums) {
        //对房间小于等于三间的特殊情况区分
        int n = nums.length;
        if (n == 0) return 0;
        else if (n == 1) return nums[0];
        else if (n == 2) return Math.max(nums[0], nums[1]);
        else if (n == 3) return Math.max(nums[0] + nums[2], nums[1]);
        //小偷偷到第三家时的金钱，等于 第一家和第三家的和
        nums[2] = nums[0] + nums[2];
        //从第四家开始遍历
        for (int i = 3; i < n; i++) {
            //偷到第i家时，判断偷的前一家是 i-2 还是 i-3 才能利益最大
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }
        //比较第n家和第n-1家，哪个适合作为小偷的最后一站
        return Math.max(nums[n - 1], nums[n - 2]);
    }
}
