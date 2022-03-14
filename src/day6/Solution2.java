package day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 567 字符串的排列
 *
 * @author llliujw
 */
public class Solution2 {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));

        String s3 = "ab", s4 = "eidboaoo";
        System.out.println(checkInclusion(s3, s4));
    }

    /**
     * 滑动窗口
     * 由于题目限定字符范围是26个小写字母，可以用长度为26的数组代替Map来统计各个字符的个数（各字符个数相同则存在同排列）
     * 通过toCharArray一次转换比charAt依次获取效率更高
     * Arrays.equals可以提交两个数组是否相同
     */
    public static boolean checkInclusion(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int n = chars1.length, m = chars2.length;
        if (n > m) return false;

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[chars1[i] - 'a'];
            ++cnt2[chars2[i] - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) return true;
        for (int i = n; i < m; ++i) {
            ++cnt2[chars2[i] - 'a'];
            --cnt2[chars2[i - n] - 'a'];
            if (Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }
}
