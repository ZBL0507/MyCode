package com.zbl.algorithm.leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @author zbl
 * @version 1.0
 * @since 2021/7/12 14:14
 */
@SuppressWarnings("unused")
public class Test0045SearchRange {
    public static void main(String[] args) {
        int[] range1 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        int[] range2 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        int[] range3 = searchRange(new int[]{6, 9}, 6);
        int[] range4 = searchRange(new int[]{-1, 0}, 0);
    }

    //根据题意，算法思想：二分查找
    private static int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1)
            return new int[]{-1, -1};

        int low = index;
        int hig = index;
        while (low > -1 && nums[low] == target)
            low--;
        while (hig < nums.length && nums[hig] == target)
            hig++;

        //修正一次
        if (low == -1)
            low = 0;
        if (hig == nums.length)
            hig = nums.length - 1;

        return new int[]{
                nums[low] == target ? low : ++low,
                nums[hig] == target ? hig : --hig
        };
    }

    private static int binarySearch(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }

        int low = 0;
        int hig = nums.length - 1;
        int mid = (low + hig) / 2;
        while (low < hig) {
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                low = mid + 1;
                mid = (low + hig) / 2;
            } else {
                hig = mid - 1;
                mid = (low + hig) / 2;
            }
        }

        if (nums[low] == target)
            return low;
        return -1;
    }
}
