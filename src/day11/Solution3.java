package day11;

import java.util.ArrayList;
import java.util.List;

/**
 * 784 字母大小写全排列
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("3z4"));
    }

    /**
     * ?不会，需复盘
     */
    public static List<String> letterCasePermutation(String S) {
        int B = 0;
        for (char c : S.toCharArray())
            if (Character.isLetter(c))
                B++;

        List<String> ans = new ArrayList<>();

        for (int bits = 0; bits < 1 << B; bits++) {
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char letter : S.toCharArray()) {
                if (Character.isLetter(letter)) {
                    if (((bits >> b++) & 1) == 1)
                        word.append(Character.toLowerCase(letter));
                    else
                        word.append(Character.toUpperCase(letter));
                } else {
                    word.append(letter);
                }
            }

            ans.add(word.toString());
        }
        return ans;
    }
}
