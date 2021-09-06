package com.zbl.algorithm.leetcode.intermediate;

/**
 * 两整数之和
 * 不使用运算符 + 和 - ​，
 * 计算两整数 a 、b ​​之和。
 * <p>
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * @author zbl
 * @version 1.0
 * @since 2021/9/6 20:48
 */
@SuppressWarnings("unused")
public class Test0066GetSum {
    public static void main(String[] args) {
        int sum = getSum(1, -2);
        int sum1 = getSum(197, -162);
        int sum2 = getSum(-12, -8);
    }

    private static int getSum(int a, int b) {
        StringBuilder str = new StringBuilder();
        //进位标志
        int flag = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            //此if中，说明 a, b 相同的某一位 一个为0， 一个为1
            if (((a & mask) ^ (b & mask)) != 0) {
                str.append(flag == 1 ? '0' : '1');
            } else { //走到这里说明a, b 相同的某一位 要么全为0，要么全为1
                str.append(flag);
                if ((a & mask) != 0)  //如果相同的这个位全为1, 则进位
                    flag = 1;
                else
                    flag = 0;
            }
        }

        char[] chars = str.toString().toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++)
            if (chars[i] == '1')
                res |= (1 << i);

        return res;
    }
}
