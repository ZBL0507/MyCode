package com.zbl.algorithm.leetcode;

/**
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：n = 45
 * 输出：false
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * 进阶：
 * <p>
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnsdi2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0010IsPowerOfThree {
    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree(19684);
        boolean powerOfThree1 = isPowerOfThree(9);
        boolean powerOfThree2 = isPowerOfThree(27);
        boolean powerOfThree3 = isPowerOfThree(6);
        boolean powerOfThree4 = isPowerOfThree(18);
    }

    private static boolean isPowerOfThree(int n) {
        if (n < 10 && n != 3 && n != 9)
            return n == 1;
        if (n % 3 != 0)
            return false;
        return isPowerOfThree(n / 3);
    }
}
