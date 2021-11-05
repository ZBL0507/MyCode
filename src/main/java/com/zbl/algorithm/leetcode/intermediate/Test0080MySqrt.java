package com.zbl.algorithm.leetcode.intermediate;

/**
 * x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 *
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * 提示：
 * 0 <= x <= 2^31 - 1
 *
 * @author zbl
 * @version 1.0
 * @since 2021/11/5 11:40
 */
@SuppressWarnings("unused")
public class Test0080MySqrt {

    public static void main(String[] args) {
        int i = mySqrt(0);
        int i2 = mySqrt(1);
        int i3 = mySqrt(2);
        int i4 = mySqrt(3);
        int i5 = mySqrt(4);
        int i6 = mySqrt(9);
        int i7 = mySqrt(2147395599);
        int i8 = mySqrt(562464195);
    }

    private static int mySqrt(int x) {
        if (x == 0)
            return 0;

        long low = 1;
        long hig = x;
        long res = -1;

        while (low <= hig) {
            long mid = low + (hig - low) / 2;
            if (mid * mid <= x) {
                res = mid;
                low = mid + 1;
            } else {
                hig = mid - 1;
            }
        }

        return (int) res;
    }
}
