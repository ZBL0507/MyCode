package com.zbl.algorithm.leetcode.intermediate;

/**
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 *  
 * <p>
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10^9
 *
 * @author zbl
 * @version 1.0
 * @since 2021/10/27 14:28
 */
@SuppressWarnings("unused")
public class Test0078UniquePaths {
    public static void main(String[] args) {
        int i = uniquePathsV1(3, 2);
        long time = System.currentTimeMillis();
        int i1 = uniquePathsV2(19, 13);
        System.out.println("消耗时间：" + (System.currentTimeMillis() - time));
        int i2 = uniquePathsV1(7, 3);
        int i3 = uniquePathsV2(3, 3);
    }

    private static int uniquePathsV2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private static int uniquePathsV1(int m, int n) {
        int[] result = new int[1];
        process(result, 0, 0, m, n);
        return result[0];
    }

    /**
     * 不同路径的核心步骤，行走
     *
     * @param result 用于记录结果
     * @param i      当前走到位置的横坐标
     * @param j      当前走到位置的纵坐标
     * @param m      给定网格的宽
     * @param n      给定网格的长
     */
    private static void process(int[] result, int i, int j, int m, int n) {
        //走到终点
        if (i == m - 1 && j == n - 1) {
            result[0]++;
            return;
        }
        //向下走的时候走出网格
        if (i >= m) {
            return;
        }
        //向右走的时候走出网格
        if (j >= n) {
            return;
        }

        //向下走
        process(result, i + 1, j, m, n);
        //向右走
        process(result, i, j + 1, m, n);
    }
}
