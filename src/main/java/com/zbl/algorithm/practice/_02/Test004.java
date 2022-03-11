package com.zbl.algorithm.practice._02;

import java.util.Scanner;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * <p>
 * 数据范围： 0 <= n <= 2^30 - 1
 * 输入描述：
 * 输入一个int整数
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 * <p>
 * 示例1
 * 输入：
 * 1516000
 * 输出：
 * 0006151
 * <p>
 * 示例2
 * 输入：
 * 0
 * 输出：
 * 0
 *
 * @author zbl
 * @version 1.0
 * @since 2022/2/16 11:28
 */
public class Test004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        StringBuilder builder = new StringBuilder(anInt + "");
        System.out.println(builder.reverse().toString());
    }
}
