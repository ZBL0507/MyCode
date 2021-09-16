package com.zbl.algorithm.leetcode.intermediate;

import java.math.BigInteger;

/**
 * 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：0
 *  
 *
 * 提示：
 * 0 <= n <= 10^4
 *
 * @author zbl
 * @version 1.0
 * @since 2021/9/10 15:42
 */
@SuppressWarnings("unused")
public class Test0069TrailingZeroes {
    public static void main(String[] args) {
        int i = trailingZeroes(7337);
        int i2 = trailingZeroes(0);

    }

    private static int trailingZeroesV2(int n) {
        if (n == 0 || n == 1)
            return 0;

        BigInteger res = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        int count = 0;
        while (res.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            count++;
            res = res.divide(BigInteger.TEN);
        }

        return count;
    }

    private static int trailingZeroes(int n) {
        String factorial = factorial(n);
        int count = 0;
        char[] chars = factorial.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] == '0')
                count++;
            else
                break;
        }

        return count;
    }

    private static String factorial(int n) {
        if (n == 0 || n == 1)
            return "1";

        BigInteger res = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            res = res.multiply(new BigInteger(i + ""));
        }

        return res.toString();
    }
}
