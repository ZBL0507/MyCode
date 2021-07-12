package com.zbl.algorithm.leetcode;

import java.util.HashMap;

/**
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * @author zbl
 * @version 1.0
 * @since 2021/7/12 17:11
 */
@SuppressWarnings("unused")
public class Test0047MajorityElement {
    public static void main(String[] args) {
        int i = majorityElement(new int[]{3, 2, 3});
        int i2 = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    private static int majorityElement(int[] nums) {
        //使用map统计频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                map.put(num, value + 1);
            }

            value = map.get(num);
            if (value > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}