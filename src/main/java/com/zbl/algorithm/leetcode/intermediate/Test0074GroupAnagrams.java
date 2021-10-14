package com.zbl.algorithm.leetcode.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * @author zbl
 * @version 1.0
 * @since 2021/10/14 9:48
 */
public class Test0074GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<MyResult> myResults = new ArrayList<>();
        for (String str : strs) {
            String sortStr = charSort(str);
            boolean flag = false;
            for (MyResult myResult : myResults) {
                if (sortStr.equals(myResult.sortStr)) {
                    myResult.group.add(str);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                MyResult myResult = new MyResult();
                myResult.sortStr = sortStr;
                myResult.group.add(str);
                myResults.add(myResult);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (MyResult myResult : myResults) {
            res.add(myResult.group);
        }
        return res;
    }

    private static String charSort(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    static class MyResult {
        String sortStr;
        List<String> group = new ArrayList<>();

        MyResult() { }
    }
}
