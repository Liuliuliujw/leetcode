package day3;

import java.util.Arrays;

/**
 * 283 移动零
 *
 * @author llliujw
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{0};

        moveZeroes(nums1);
        moveZeroes(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

    }

    /**
     * 双指针，一个指向已读取数组的下标，一个指向整理后下标
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        int temp = 0;
        while (temp < nums.length) {
            if (nums[temp] != 0) {
                nums[index++] = nums[temp];
            }
            temp++;
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 第一版，暴力
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(1)
     */
    public static void moveZeroes1(int[] nums) {
        int left = 0, right = nums.length;
        while (left != right) {
            if (nums[left] == 0) {
                System.arraycopy(nums, left + 1, nums, left, right - 1 - left);
                nums[--right] = 0;
            } else {
                left++;
            }
        }
    }
}
