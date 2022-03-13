package day4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 557 反转字符串中的单词 III
 *
 * @author llliujw
 */
public class Solution2 {
    public static void main(String[] args) {
        String s1 = "Let's take LeetCode contest";
        String s2 = "God Ding";

        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
    }

    /**
     * 转换为字符数组，依次遍历，直接操作字符数组反转
     * 时间复杂度 O(n) --> 3ms --- 93.68%
     * 空间复杂度 O(n)
     */
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' ') {
                int left = idx, right = i - 1;
                reserve(chars, left, right);
                idx = i + 1;
            }
        }
        reserve(chars, idx, n - 1);
        return String.valueOf(chars);
    }

    private static void reserve(char[] chs, int left, int right) {
        while (left < right) {
            char tmp = chs[left];
            chs[left] = chs[right];
            chs[right] = tmp;
            left++;
            right--;
        }
    }

    /**
     * 第二版
     * 转换为字符数组，依次遍历，利用栈反转
     * 时间复杂度 O(n) --> 16ms
     * 空间复杂度 O(n)
     */
    public static String reverseWords2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                popAllToBuffer(stack, stringBuilder);
                stringBuilder.append(" ");
            } else {
                stack.push(c);
            }
        }
        popAllToBuffer(stack, stringBuilder);
        return stringBuilder.toString();
    }

    private static void popAllToBuffer(Deque<Character> stack, StringBuilder stringBuilder) {
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
    }

    /**
     * 第一版
     * 依照空格分割成单词数组，再将各个单词转换为字符数组逆序append到缓冲区
     * 时间复杂度 O(n) --> 6ms
     * 空间复杂度 O(n)
     */
    public static String reverseWords1(String s) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                stringBuilder.append(chars[j]);
            }
            if (i != words.length - 1) stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
