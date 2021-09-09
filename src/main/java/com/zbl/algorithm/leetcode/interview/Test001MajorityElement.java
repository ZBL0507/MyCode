package com.zbl.algorithm.leetcode.interview;

/**
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * @author zbl
 * @version 1.0
 * @since 2021/9/9 15:34
 */
@SuppressWarnings("unused")
public class Test001MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int element = majorityElement(nums);
    }

    private static int majorityElement(int[] nums) {
        int count = 0;
        int curNum = nums[0];

        for (int num : nums) {
            if (curNum == num)
                count++;
            else {
                if (count == 0) {
                    count = 1;
                    curNum = num;
                } else
                    count--;
            }
        }

        return curNum;
    }
}
