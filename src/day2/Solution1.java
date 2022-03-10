package day2;

import java.util.Arrays;

/**
 * 977 有序数组的平方
 *
 * @author llliujw
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-4, -1, 0, 3, 10};
        int[] nums2 = new int[]{-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums1)));
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }

    /**
     * 修改整合逻辑后
     */
    public static int[] sortedSquares(int[] nums) {
        int temp = 0;
        //找到升序数组中最小的非负数
        while (nums[temp] < 0 && temp < nums.length - 1) {
            temp++;
        }
        int[] result = new int[nums.length];
        int left = temp - 1;
        int right = temp;
        for (int i = 0; i < nums.length; i++) {
            if (right > nums.length - 1) {
                result[i] = nums[left] * nums[left];
                left--;
            } else if (left < 0) {
                result[i] = nums[right] * nums[right];
                right++;
            } else if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left--;
            } else {
                result[i] = nums[right] * nums[right];
                right++;
            }
        }
        return result;
    }

    /**
     * 我的第一版答案
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static int[] sortedSquares1(int[] nums) {
        int temp = 0;
        //找到升序数组中最小的非负数
        while (nums[temp] < 0 && temp < nums.length - 1) {
            temp++;
        }
        int[] result = new int[nums.length];
        if (temp == 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = nums[i] * nums[i];
            }
        } else {
            int left = temp - 1;
            int right = temp;
            for (int i = 0; i < nums.length; i++) {
                if (right > nums.length - 1) {
                    result[i] = nums[left] * nums[left];
                    left--;
                    continue;
                } else if (left < 0) {
                    result[i] = nums[right] * nums[right];
                    right++;
                    continue;
                }
                if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                    result[i] = nums[left] * nums[left];
                    left--;
                } else {
                    result[i] = nums[right] * nums[right];
                    right++;
                }
            }
        }
        return result;
    }
}
