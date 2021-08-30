package com.zbl.algorithm.leetcode.primary;

/**
 * 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 * @author zbl
 * @version 1.0
 * @since 2021/6/23 12:23
 */
public class Test0040HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(3, 1));
    }

    private static int hammingDistance(int x, int y) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            int pX = (x & 1);
            int pY = (y & 1);
            if (pX != pY)
                count++;
            x = x >> 1;
            y = y >> 1;
        }

        return count;
    }
}
