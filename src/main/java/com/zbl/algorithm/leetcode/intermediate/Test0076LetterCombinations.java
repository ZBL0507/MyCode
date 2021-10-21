package com.zbl.algorithm.leetcode.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @author zbl
 * @version 1.0
 * @since 2021/10/21 9:29
 */
@SuppressWarnings("unused")
public class Test0076LetterCombinations {

    private static HashMap<String, List<String>> map = new HashMap<>();

    static {
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("2");
        List<String> strings1 = letterCombinations("23");
    }

    private static List<String> letterCombinations(String digits) {
        if (null == digits || digits.length() == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        process(digits, 0, strings, result);

        return result;
    }

    /**
     * @param index   当前处理字符的下标
     * @param inStr   给定字符串
     * @param strings 保存某次处理的结果
     * @param result  保存最后的结果
     */
    private static void process(String inStr, int index, ArrayList<String> strings, ArrayList<String> result) {
        //满足结果条件，加入结果集
        if (strings.size() == inStr.length()) {
            StringBuilder builder = new StringBuilder();
            for (String str : strings) {
                builder.append(str);
            }
            result.add(builder.toString());
            return;
        }

        String curChar = inStr.charAt(index) + "";
        List<String> curList = map.get(curChar);
        for (String ss : curList) {
            strings.add(ss);
            process(inStr, index + 1, strings, result);
            //回溯处理
            strings.remove(strings.size() - 1);
        }
    }
}
