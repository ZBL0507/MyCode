package com.zbl.algorithm.leetcode;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Test0001 {
    public static void main(String[] args) {
        containsDuplicate(new int[]{1, 2, 3, 1});
        containsDuplicate(new int[]{1, 2, 3, 4});
        containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
    }

    @SuppressWarnings("Duplicates")
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 1)
            return false;

        int temp;
        int swapCount;
        for (int i = 0; i < nums.length - 1; i++) {
            swapCount = 0;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapCount++;
                }
            }
            if (swapCount == 0)
                break;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}
