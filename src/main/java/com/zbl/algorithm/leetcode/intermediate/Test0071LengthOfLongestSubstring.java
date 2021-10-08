package com.zbl.algorithm.leetcode.intermediate;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @author zbl
 * @version 1.0
 * @since 2021/10/8 15:37
 */
public class Test0071LengthOfLongestSubstring {
    public static void main(String[] args) {
        int abcabcbb = lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
        int bbbbb = lengthOfLongestSubstring("bbbbb");
        System.out.println(bbbbb);
        int pwwkew = lengthOfLongestSubstring("pwwkew");
        System.out.println(pwwkew);
    }

    private static int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s))
            return 0;

        char[] chars = s.toCharArray();
        int longestLength = 0;
        HashSet<Character> cache = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (cache.contains(chars[j])) {
                    longestLength = Math.max(longestLength, cache.size());
                    cache.clear();
                    break;
                }
                cache.add(chars[j]);
            }
        }

        longestLength = Math.max(longestLength, cache.size());
        return longestLength;
    }
}
