package com.zbl.algorithm.leetcode.primary;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * @author zbl
 * @version 1.0
 * @since 2021/8/26 20:28
 */
@SuppressWarnings("unused")
public class Test0059LongestPalindrome {
    public static void main(String[] args) {
        String babad = longestPalindrome("babad");
        String cbbd = longestPalindrome("cbbd");
        String ac = longestPalindrome("ac");
        String a = longestPalindrome("a");

    }

    private static String longestPalindrome(String s) {
        //首先对字符串做特殊的处理 babad -> #b#a#b#a#d#
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        str.append('#');
        for (char ch : chars) {
            str.append(ch).append('#');
        }
        char[] array = str.toString().toCharArray();

        //回文中心
        int center = -1;
        //回文半径
        int r = -1;
        for (int i = 0; i < array.length; i++) {
            int tempR = 0;
            //每次探测的左边
            int left = i - 1;
            //每次探测的右边
            int right = i + 1;
            while (left > -1 && right < array.length && array[left] == array[right]) {
                left--;
                right++;
                tempR++;
            }
            //如果找到更大的回文串，则记录下它的中心和半径
            if (tempR > r) {
                r = tempR;
                center = i;
            }
        }

        boolean flag = false;
        if (center % 2 == 0)
            flag = true;

        //求出原字符数组中的回文中心，回文半径
        center = center / 2;
        r = r / 2;

        int begin = center - r;
        int end = center + r;
        String result = "";
        if (flag)
            result = new String(chars, begin, end - begin);
        else
            result = new String(chars, begin, end - begin + 1);

        return result;
    }
}
