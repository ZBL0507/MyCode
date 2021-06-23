package com.zbl.algorithm.leetcode;

/**
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 * @author zbl
 * @version 1.0
 * @since 2021/6/23 12:14
 */
public class Test0039HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(1));
        System.out.println(hammingWeight(31));
    }

    // you need to treat n as an unsigned value
    private static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }
}
