package com.zbl.algorithm.leetcode.intermediate;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 * 1 <= n <= 8
 *
 * @author zbl
 * @version 1.0
 * @since 2021/10/20 17:24
 */
public class Test0075GenerateParenthesis {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }

    private static List<String> generateParenthesis(int n) {
        int left = 0;
        int right = 0;
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        dfs(left, right, n, strings, result);
        return result;
    }

    private static void dfs(int left, int right, int n, List<String> strings, List<String> result) {
        //遇到满足条件的结果
        if (strings.size() == n * 2) {
            StringBuilder builder = new StringBuilder();
            for (String string : strings) {
                builder.append(string);
            }
            result.add(builder.toString());
            return;
        }

        if (left < n) {
            strings.add("(");
            dfs(left + 1, right, n, strings, result);
            strings.remove(strings.size() - 1);
        }

        if (right < left) {
            strings.add(")");
            dfs(left, right + 1, n, strings, result);
            strings.remove(strings.size() - 1);
        }
    }
}
