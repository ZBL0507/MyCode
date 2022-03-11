package com.zbl.algorithm.practice._0311;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 描述
 * 对字符串中的所有单词进行倒排。
 * 说明：
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 * 数据范围：字符串长度满足 1 \le n \le 10000 \1≤n≤10000
 * 输入描述：
 * 输入一行以空格来分隔的句子
 * 输出描述：
 * 输出句子的逆序
 * 示例1
 * 输入：
 * I am a student
 * 输出：
 * student a am I
 * 示例2
 * 输入：
 * $bo*y gi!r#l
 * 输出：
 * l r gi y bo
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/11 15:04
 */
public class Test006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String src = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        for (char ch : src.toCharArray()) {
            if ((ch >= 'A' && ch <= 'Z')
                    || (ch >= 'a' && ch <= 'z')) {
                builder.append(ch);
            } else {
                builder.append('#');
            }
        }

        String[] split = builder.toString().split("#");
        for (int i = split.length - 1; i >= 0; i--) {
            System.out.print(split[i] + " ");
        }
    }
}
