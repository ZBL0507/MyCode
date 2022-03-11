package com.zbl.algorithm.practice._02;

import java.util.Scanner;

/**
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 * <p>
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 * 输入一个整数（int类型）
 * <p>
 * 输出描述：
 * 这个数转换成2进制后，输出1的个数
 *
 * @author zbl
 * @version 1.0
 * @since 2022/2/16 9:38
 */
public class Test002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();

        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((anInt & 1) == 1) {
                count++;
            }
            anInt = anInt >> 1;
        }

        System.out.println(count);
    }
}
