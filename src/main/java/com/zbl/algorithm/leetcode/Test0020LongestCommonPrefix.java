package com.zbl.algorithm.leetcode;

import java.util.ArrayList;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0020LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        String[] strs2 = {"dog","racecar","car"};
        String s1 = longestCommonPrefix(strs2);
    }

    private static String longestCommonPrefix(String[] strs) {
        ArrayList<char[]> list = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        for (String str : strs) {
            if ("".equals(str))
                return "";
            list.add(str.toCharArray());
            if (str.length() < minIndex)
                minIndex = str.length();
        }

        StringBuilder result = new StringBuilder();
        T1:for (int i = 0; i < minIndex; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j)[i] != list.get(j + 1)[i])
                    break T1;
            }
            result.append(list.get(0)[i]);
        }

        return result.toString();
    }
}
