package com.zbl.algorithm.leetcode;

/**
 * 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 *
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0019 {
    public static void main(String[] args) {
        int index1 = strStr("hello", "ll");
        int index2 = strStr("aaaaa", "bba");
        int index3 = strStr("", "");
    }

    private static int strStr(String haystack, String needle) {
        if ("".equals(needle))
            return 0;
        if ("".equals(haystack))
            return -1;

        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();

        if (chars1.length < chars2.length)
            return -1;

        int loopCount = chars1.length - chars2.length;

        for (int i = 0; i <= loopCount; i++) {
            int j = 0;
            for (; j < chars2.length; j++) {
                if (chars1[j + i] != chars2[j])
                    break;
            }
            if (j == chars2.length)
                return i;
        }
        return -1;
    }
}
