package com.zbl.algorithm.leetcode;

/**
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0004Reverse {
    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        int reverse2 = reverse(-230);
    }

    private static int reverse(int x) {
        boolean negative = x < 0;
        String str = Math.abs(x) + "";
        str = new StringBuilder(str).reverse().toString();
        int result = 0;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
        if (negative)
            return 0 - result;
        return result;
    }
}
