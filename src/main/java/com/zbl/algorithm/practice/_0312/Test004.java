package com.zbl.algorithm.practice._0312;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * 描述
 * 根据输入的日期，计算是这一年的第几天。
 * 保证年份为4位数且日期合法。
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(1)\O(1)
 * 输入描述：
 * 输入一行，每行空格分割，分别是年，月，日
 * 输出描述：
 * 输出是这一年的第几天
 * 示例1
 * 输入：
 * 2012 12 31
 * 输出：
 * 366
 * 示例2
 * 输入：
 * 1982 3 4
 * 输出：
 * 63
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/12 19:38
 */
public class Test004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] split = line.split(" ");

        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        LocalDate date = LocalDate.of(year, month, day);

        System.out.println(date.getDayOfYear());
    }
}
