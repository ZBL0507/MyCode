package com.zbl.algorithm.interview;

/**
 * 股票买卖，只允许买卖一次，求最大的利润
 */
@SuppressWarnings("all")
public class FindMaxProfit {
    public static void main(String[] args) {
        maxProfit(new int[]{7, 7});
        //此组数据即可验证解法存在问题
        maxProfit(new int[]{7, 8, 9, 2, 4, 6, 7, 1, 3});

        maxProfit(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        maxProfit2(new int[]{7, 7});

        maxProfit2(new int[]{7, 8, 9, 2, 4, 6, 7, 1, 3});

        maxProfit2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        maxProfit2(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
    }

    /**
     * 求最大利润       请注意该解法存在问题！！！
     *
     * @param prices 价格数组，代表每天的价格
     * @return 找到的最大利润，没有则返回0
     */
    public static int maxProfit(int[] prices) {
        if (prices.length > 1) {
            int maxVal = prices[0];
            int maxIndex = 0;
            int minVal = prices[0];
            int minIndex = 0;
            //找出最大值及其下标， 最小值及其下标
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > maxVal) {
                    maxIndex = i;
                    maxVal = prices[i];
                }
                if (prices[i] < minVal) {
                    minIndex = i;
                    minVal = prices[i];
                }
            }

            /**
             * 以下求取最大利润的做法是否正确值得思考：
             * 从最小值向右找一个最大值  [minIndex, prices.length] --> tempMaxVal
             * 从最大值向左找一个最小值  [0,  maxIndex]  --> tempMinVal
             * 求出两对差值 (tempMaxVal - minVal),  (maxVal - tempMinVal)   取两对差值中的大者为最终结果
             */
            //从最大值向左找一个最小值  [0,  maxIndex]  --> tempMinVal
            int tempMinVal = prices[0];
            for (int i = 1; i < maxIndex; i++) {
                if (tempMinVal > prices[i])
                    tempMinVal = prices[i];
            }
            //从最小值向右找一个最大值  [minIndex, prices.length] --> tempMaxVal
            int tempMaxVal = prices[minIndex + 1];
            for (int i = minIndex + 2; i < prices.length; i++) {
                if (tempMaxVal < prices[i])
                    tempMaxVal = prices[i];
            }

            int result1 = maxVal - tempMinVal;
            int result2 = tempMaxVal - minVal;
            return result1 >= result2 ? result1 : result2;

            /**
             * 类似以下走势的数据就会存在问题，因此此解法错误！！！
             *
             * 正确的做法应该是求出所有的波峰波谷(波峰在波谷之后)之差，还有可能波峰波谷之间还夹杂着波峰波谷
             * 其中最大的差即是我们要寻求的答案
             *
             *   maxVal
             *     -
             *   -   -                   -
             * -       -               -   -
             *           -           -       -
             *             -       -           -
             *               -   -               -
             *                 -                   -       -
             *                                       -   -
             *                                         -
             *                                       minVal
             */
        }
        return 0;
    }

    /**
     * 股票买卖，只允许一次的情况下正确解法
     *
     * @param prices 股票价格数组
     * @return 返回买卖一次的情况下最大利润
     */
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int i = 0;
        int j = 1;
        int result = prices[j] - prices[i];
        while (i < j && i < prices.length && j < prices.length) {
            if (prices[j] - prices[i] > result)
                result = prices[j] - prices[i];
            j++;
            if (j == prices.length) {
                i++;
                j = i + 1;
            }
        }
        return result > 0 ? result : 0;
    }
}
