package com.zbl.algorithm.practice._02;

import java.util.Scanner;

/**
 * @author zbl
 * @version 1.0
 * @since 2022/2/16 9:26
 * <p>
 * <p>
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 * <p>
 * 输入描述：
 * 输入一个正浮点数值
 * <p>
 * 输出描述：
 * 输出该数值的近似整数值
 * <p>
 * 示例1
 * 输入：
 * 5.5
 * 输出：
 * 6
 * 说明：
 * 0.5>=0.5，所以5.5需要向上取整为6
 * <p>
 * 示例2
 * 输入：
 * 2.499
 * 输出：
 * 2
 * 复制
 * 0.499 < 0.5，2.499向下取整为2
 */
public class Test001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float aFloat = scanner.nextFloat();
        int result = (int) (aFloat + 0.5);
        System.out.println(result);
    }
}
