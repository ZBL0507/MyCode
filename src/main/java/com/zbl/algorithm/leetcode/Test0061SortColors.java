package com.zbl.algorithm.leetcode;

/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 * <p>
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * @author zbl
 * @version 1.0
 * @since 2021/8/29 20:10
 */
public class Test0061SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        sortColors(nums);
    }

    private static void sortColors(int[] nums) {
        //base case
        if (nums == null || nums.length == 1)
            return;

        int mid = nums.length - 1;
        int p = 0;
        int q = nums.length - 1;
        while (q > -1 && p < nums.length && p < q) {
            while (nums[q] == 2) {
                q--;
                mid = q;
                if (q == -1)
                    return;
            }
            while (p < nums.length && nums[p] != 2) {
                p++;
                if (p == nums.length)
                    mid = nums.length - 1;
            }
            if (p < nums.length && p < q) {
                swap(nums, p, q);
                p++;
                q--;
                mid = q;
                while (nums[q] == 2) {
                    q--;
                    mid = q;
                    if (q == -1)
                        return;
                }
            }
        }

        p = 0;
        q = mid;
        while (p < nums.length && q > -1 && p < q) {
            while (q > -1 && nums[q] == 1) {
                q--;
            }
            while (p < nums.length && nums[p] == 0) {
                p++;
            }
            if (p < q) {
                swap(nums, p, q);
            }
        }
    }

    private static void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

}
