package com.zbl.algorithm.practice;

import java.util.Scanner;

/**
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 输入描述：
 * 输入一行，为一个只包含小写字母的字符串。
 * 输出描述：
 * 输出该字符串反转后的字符串。
 *
 * 示例1
 * 输入：
 * abcd
 * 输出：
 * dcba
 *
 * @author zbl
 * @version 1.0
 * @since 2022/2/16 11:36
 */
public class Test005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(new StringBuilder(str).reverse());
    }
}
