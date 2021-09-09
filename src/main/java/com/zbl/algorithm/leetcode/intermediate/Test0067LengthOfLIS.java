package com.zbl.algorithm.leetcode.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 最长上升子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *  
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * 进阶：
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 *
 * @author zbl
 * @version 1.0
 * @since 2021/9/9 16:42
 */
@SuppressWarnings("unused")
public class Test0067LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int i = lengthOfLIS(nums);
        int i3 = lengthOfLISV2(nums);
        int i1 = lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        int i2 = lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7});
    }

    //v2版本 还是错误！！！
    private static int lengthOfLISV2(int[] nums) {
        //用于记录结果
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums.length - i < cnt)
                break;

            int count = 1;
            int last = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > last) {
                    count++;
                    last = nums[j];
                }
            }
            if (count > cnt)
                cnt = count;

            while (i < nums.length - 1 && nums[i + 1] > nums[i])
                i++;
        }

        return cnt;
    }

    static class MyDS {
        int num;
        int index;

        MyDS(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    // 错误版本 ！！！
    private static int lengthOfLIS(int[] nums) {
        MyDS[] arr = new MyDS[nums.length];
        //处理为需要的数据结构
        for (int i = 0; i < nums.length; i++)
            arr[i] = new MyDS(nums[i], i);

        Arrays.sort(arr, Comparator.comparingInt(o -> o.num));

        int resultCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr.length - i < resultCount)
                break;

            int resCount = 1;
            MyDS tempLast = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].num > tempLast.num && arr[j].index > tempLast.index) {
                    resCount++;
                    tempLast = arr[j];
                }
            }
            if (resCount > resultCount)
                resultCount = resCount;
        }

        return resultCount;
    }
}
