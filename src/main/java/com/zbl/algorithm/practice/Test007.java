package com.zbl.algorithm.practice;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * 数据范围： 1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 输出：
 * 2
 *
 * @author zbl
 * @version 1.0
 * @since 2022/2/25 11:47
 */
public class Test007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String line2 = scanner.nextLine();
        line = line.toLowerCase();
        line2 = line2.toLowerCase();

        int count = 0;

        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (line2.charAt(0) == charArray[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
