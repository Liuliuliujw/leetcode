package alg1.day4;

import java.util.Arrays;

/**
 * 344 反转字符串
 *
 * @author llliujw
 */
public class Solution1 {
    public static void main(String[] args) {
        char[] s1 = "hello".toCharArray();
        char[] s2 = "Hannah".toCharArray();

        reverseString(s1);
        reverseString(s2);

        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
    }

    /**
     * 限制： 原地修改数组，O(1)的额外空间
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
