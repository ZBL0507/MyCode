package com.zbl.algorithm.practice;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 * 数据范围： 1 <= n <= 10^8
 * 输入描述：
 * 输入一个int型整数
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * 示例1
 * 输入：
 * 9876673
 * 输出：
 * 37689
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/9 18:07
 */
public class Test012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();

        char[] charArray = (anInt + "").toCharArray();
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for (int i = charArray.length - 1; i >= 0; i--) {
            linkedHashSet.add(charArray[i]);
        }

        StringBuilder builder = new StringBuilder();
        linkedHashSet.forEach(builder::append);

        System.out.println(Integer.parseInt(builder.toString()));
    }
}
