package com.zbl.algorithm.practice._02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 数据范围：1≤n≤2×10^9 +14
 * 输入描述：
 * 输入一个整数
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 * 示例1
 * 输入：
 * 180
 * 输出：
 * 2 2 3 3 5
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/9 22:12
 */
public class Test016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        if (anInt == 1) {
            System.out.println(1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (anInt != 1) {
            if (anInt % 2 == 0) {
                list.add(2);
                anInt = anInt / 2;
            } else if (anInt % 3 == 0) {
                list.add(3);
                anInt = anInt / 3;
            } else if (anInt % 5 == 0) {
                list.add(5);
                anInt = anInt / 5;
            } else if (anInt % 7 == 0) {
                list.add(7);
                anInt = anInt / 7;
            } else if (anInt % 13 == 0) {
                list.add(13);
                anInt = anInt / 13;
            } else if (anInt % 23 == 0) {
                list.add(23);
                anInt = anInt / 23;
            } else if (anInt % 107 == 0) {
                list.add(107);
                anInt = anInt / 107;
            } else if (anInt % 17 == 0) {
                list.add(17);
                anInt = anInt / 17;
            } else {
                list.add(anInt);
                break;
            }
        }

        list.forEach(e -> System.out.print(e + " "));
    }
}
