package com.zbl.algorithm.leetcode.intermediate;

import java.util.ArrayList;

/**
 * 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * <p>
 * 提示：
 * 1 <= n <= 231 - 1
 *
 * @author zbl
 * @version 1.0
 * @since 2021/9/10 14:51
 */
@SuppressWarnings("unused")
public class Test0068IsHappy {
    public static void main(String[] args) {
        boolean happy = isHappy(81);
        boolean happy2 = isHappy(2);
        boolean happy3 = isHappy(7);
    }

    private static boolean isHappy(int n) {
        while (!isLt10(n))
            n = process(n);

        return n == 1 || n == 7;
    }

    private static int process(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }

        int res = 0;
        for (Integer e : list)
            res += e * e;

        return res;
    }

    private static boolean isLt10(int n) {
        return n > 0 && n < 10;
    }
}
