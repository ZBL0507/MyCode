package com.zbl.algorithm.practice._0311;

import java.util.Scanner;

/**
 * 描述
 * 输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 * 数据范围：字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ， 1 \le k \le n \1≤k≤n
 * 输入描述：
 * 1.输入待截取的字符串
 * 2.输入一个正整数k，代表截取的长度
 *
 * 输出描述：
 * 截取后的字符串
 * 示例1
 * 输入：
 * abABCcDEF
 * 6
 * 输出：
 * abABCc
 * 示例2
 * 输入：
 * bdxPKBhih
 * 6
 * 输出：
 * bdxPKB
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/11 12:10
 */
public class Test003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int index = Integer.parseInt(scanner.nextLine());

        System.out.println(str.substring(0, index));
    }
}
