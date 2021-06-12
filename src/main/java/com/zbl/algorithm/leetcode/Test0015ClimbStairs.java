package com.zbl.algorithm.leetcode;

import java.util.HashMap;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn854d/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@SuppressWarnings("unused")
public class Test0015ClimbStairs {
    public static void main(String[] args) {
        int c1 = climbStairs(4);
        int c2 = climbStairs(5);
    }

    /**
     * 简单分析可知 f(n) = f(n-1) + f(n-2)
     * 故此可以使用 动态规划 快速求解
     */
    private static int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return innerClimbStairs(n, map);
    }

    /**
     * 动态规划求解  这里采用自上而下的求解方式
     *
     * @param n   台阶数
     * @param map 保存中间结果 防止无效的递归
     * @return 返回结果
     */
    private static int innerClimbStairs(int n, HashMap<Integer, Integer> map) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (map.get(n) != null)
            return map.get(n);
        int n2 = innerClimbStairs(n - 2, map);
        int n1 = innerClimbStairs(n - 1, map);
        map.put(n, n2 + n1);
        return n1 + n2;
    }
}
