package com.zbl.algorithm.practice._0312;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 描述
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 * 输入n，请输出n以内(含n)完全数的个数。
 * 数据范围： 1 \le n \le 5 \times 10^{5} \1≤n≤5×10
 * 5
 * 输入描述：
 * 输入一个数字n
 * 输出描述：
 * 输出不超过n的完全数的个数
 * 示例1
 * 输入：
 * 1000
 * 输出：
 * 3
 *
 * @author zbl
 * @version 1.0
 * @since 2022/3/12 19:30
 */
public class Test003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anInt = scanner.nextInt();
        int count = 0;

        for (int i = 1; i <= anInt; i++) {
            if (isWanQuan(i))
                count++;
        }
        System.out.println(count);
    }

    public static boolean isWanQuan(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                list.add(i);
            }
        }
        return list.stream().reduce(0, Integer::sum) == num;
    }
}
