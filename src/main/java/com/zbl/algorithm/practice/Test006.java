package com.zbl.algorithm.practice;

import java.util.Scanner;

/**
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 * <p>
 * 示例1
 * 输入：
 * hello nowcoder
 * 输出：
 * 8
 * 说明：
 * 最后一个单词为nowcoder，长度为8
 *
 * @author zbl
 * @version 1.0
 * @since 2022/2/25 11:37
 */
public class Test006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int id = line.lastIndexOf(' ');
        if (id == -1) {
            System.out.println(line.length());
            return;
        }
        System.out.println(line.length() - id - 1);
    }
}
