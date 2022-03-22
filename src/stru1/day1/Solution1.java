package stru1.day1;

import java.util.HashSet;
import java.util.Set;

/**
 * 学习计划 ： 数据结构入门 ==> 开始
 *
 * 217. 存在重复元素
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    /**
     * 利用set集合，遍历数组判断是否重复
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))return true;
            set.add(num);
        }
        return false;
    }
}
