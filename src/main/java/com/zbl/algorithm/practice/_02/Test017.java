package com.zbl.algorithm.practice._02;

import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 *  输入一个整数（int类型）
 * 输出描述：
 *  这个数转换成2进制后，输出1的个数
 * 示例1
 * 输入：
 * 5
 * 输出：
 * 2
 * 示例2
 * 输入：
 * 0
 * 复制
 * 输出：
 * 0
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/9 22:47
 */
public class Test017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anInt = scanner.nextInt();
        String string = Integer.toBinaryString(anInt);

        int cnt = 0;
        for (char ch : string.toCharArray()) {
            if (ch == '1') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
