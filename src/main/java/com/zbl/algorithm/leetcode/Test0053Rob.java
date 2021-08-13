package com.zbl.algorithm.leetcode;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * @author zbl
 * @version 1.0
 * @since 2021/8/13 9:57
 */
@SuppressWarnings("unused")
public class Test0053Rob {
    public static void main(String[] args) {
        int rob1 = rob(new int[]{1, 2, 3, 1});
        int rob2 = rob(new int[]{2, 7, 9, 3, 1});
    }

    private static int rob(int[] nums) {
        int[][] help = new int[nums.length][2];
        help[0][0] = 0;
        help[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            help[i][0] = Math.max(help[i - 1][0], help[i - 1][1]);
            help[i][1] = help[i - 1][0] + nums[i];
        }

        return Math.max(help[nums.length - 1][0], help[nums.length - 1][1]);
    }
}
