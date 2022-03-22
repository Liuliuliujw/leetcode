package alg1.day1;

/**
 * 35 搜索插入位置
 *
 * @author llliujw
 */
public class Solution3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
        System.out.println(searchInsert(new int[]{1}, 0));
    }

    /**
     * 二分查找，当边界相交 target等于小于nums[mid]返回mid，大于返回 mid+1
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
