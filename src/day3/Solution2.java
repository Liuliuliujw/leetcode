package day3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 167 两数之和 II - 输入有序数组
 *
 * @author llliujw
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{2, 7, 11, 15};
        int[] numbers2 = new int[]{2, 3, 4};

        System.out.println(Arrays.toString(twoSum(numbers1, 9)));
        System.out.println(Arrays.toString(twoSum(numbers2, 6)));
    }

    /**
     * 题目限制：
     * 常量级额外空间
     * <p>
     * 思路 ：数组是有序的，
     * 1、遍历数组，用二分查找在[temp,n]找 target-numbers[temp]
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(1)
     * <p>
     * 2、双指针，指向两端，求和向中间逼近直至和等于target
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) { //sum小于target，移动left使sum增大
                ++left;
            } else { //sum大于target，移动right使sum缩小
                --right;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 散列表查找，不符合题目要求 -- 常量级额外空间
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public static int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            }
            map.put(numbers[i], i + 1);
        }
        return null;
    }

    /**
     * 两次遍历
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public static int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[]{0, 0};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == target - numbers[i]) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return result;
    }
}
