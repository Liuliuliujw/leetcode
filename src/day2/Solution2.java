package day2;

import java.util.Arrays;

/**
 * 189 轮转数组
 *
 * @author llliujw
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = new int[]{-1, -100, 3, 99};

        rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));

        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * 我的答案
     * 利用额外数值存储后替换
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * 这与官方方法一类似，但官方更为简单，即：
     * 将原数组中的每一个数放到新数值的 (i+k) mod nums.length的下标位置
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length; //轮转 num.length 次等于没变
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp, 0, temp.length);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, temp.length);
    }

    /**
     * 官方方法二 ： 环状替换
     * 替换时只用了一个temp来存储
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public void rotate_m2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start; //存储当前下标
            int prev = nums[start];
            do { //以K为步长交换数组值
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    /**
     * 求最大公约数
     */
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    /**
     * 官方方法三 ： 数组反转
     * 由于反转只需要一个temp来存储交换的值，其空间复杂度为O(1)
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public void rotate_m3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    /**
     * 第一版答案
     * 依次轮转
     */
    public static void rotate1(int[] nums, int k) {
        int temp;
        while (k > 0) {
            temp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = temp;
            k--;
        }
    }
}
