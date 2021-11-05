package com.zbl.algorithm.leetcode.intermediate;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：coins = [1], amount = 1
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 *
 * @author zbl
 * @version 1.0
 * @since 2021/11/1 16:19
 */

@SuppressWarnings("unused")
public class Test0079CoinChange {

    public static void main(String[] args) {
        int[] coins = {2};
        int change = coinChangeV2(coins, 6);
        int change2 = coinChangeV2(coins, 17);
        System.out.println(change);
    }


    //V2版本，动态规划
    private static int coinChangeV2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 10);
        dp[0] = 0;

        for (int i = 0; i < amount + 1; i++)
            for (int coin : coins)
                if (coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return dp[amount] > amount ? -1 : dp[amount];
    }


    private static int coinChange(int[] coins, int amount) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int coin : coins)
            map.put(coin, 1);

        return process(coins, amount, map);
    }

    private static int process(int[] coins, int amount, HashMap<Integer, Integer> map) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;

        //如果算过这个值，则不必再次计算
        Integer cacheValue = map.get(amount);
        if (cacheValue != null)
            return cacheValue;

        //用来记录组成 amount 需要的最小硬币数量
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            //算出 amount - coin 需要的硬币数量
            int minCount = process(coins, amount - coin, map);
            if (minCount >= 0 && minCount < min)
                min = minCount + 1;  // minCount 满足条件时，更新 min

            //更新组成 amount 需要的最小硬币数量
            map.put(amount, min == Integer.MAX_VALUE ? -1 : min);
        }

        return map.get(amount);
    }
}
