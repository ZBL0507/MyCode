package com.zbl.algorithm.leetcode.intermediate;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 *  
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 *
 * @author zbl
 * @version 1.0
 * @since 2021/10/11 10:26
 */
@SuppressWarnings("unused")
public class Test0072MyPow {
    public static void main(String[] args) {
        double v = myPowV2(2, 10);
        double v2 = myPowV2(2.1, 3);
        double v3 = myPowV2(2, -2);
    }

    private static double myPowV2(double x, int n) {
        boolean isNegative = n < 0;
        int absn = Math.abs(n);
        if (isNegative)
            return 1 / doMyPow(x, absn);
        else
            return doMyPow(x, absn);
    }

    private static double doMyPow(double x, int n) {
        if (0 == n)
            return 1;

        if ((n & 1) == 1) {
            return x * doMyPow(x * x, n / 2);
        }

        return doMyPow(x * x, n / 2);
    }


    private static double myPow(double x, int n) {
        if (0 == n)
            return 1;

        boolean isNegative = n < 0;

        double absn = Math.abs(n);

        double result = 1;

        for (int i = 0; i < absn; i++) {
            result *= x;
        }

        if (!isNegative)
            return result;

        return  1 / result;
    }
}
