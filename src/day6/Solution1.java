package day6;

/**
 * 3 无重复字符的最长子串
 *
 * @author llliujw
 */
public class Solution1 {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));
    }

    /**
     * 滑动窗口
     * 为官方题解不同的是，官方采用HashSet判断重复字符，然后依次移动边界
     * 这里我们可以直接遍历子串找到重复字符的下标，然后直接移动边界到下标位置
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int start = 0, end = 0, max_len = 1;
        while (end < chars.length) { //遍历字符数组
            for (int i = start; i < end; i++) {
                if (chars[i] == chars[end]) { //如果出现重复字符
                    max_len = Math.max(max_len, (end - start)); //先记录当前子串长度
                    start = i + 1; //再移动start到重复字符的后面
                    break;
                }
            }
            end++;
        }
        max_len = Math.max(max_len, (end - start)); //计算最后一个子串的长度
        return max_len;
    }
}

