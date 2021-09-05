package com.zbl.algorithm.leetcode.intermediate;

/**
 * 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 * <p>
 * 示例 2：
 * 输入：nums = [5,4,3,2,1]
 * 输出：false
 * 解释：不存在满足题意的三元组
 * <p>
 * 示例 3：
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 *  
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 *  
 * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
 *
 * @author zbl
 * @version 1.0
 * @since 2021/9/5 19:28
 */
@SuppressWarnings("all")
public class Test0065IncreasingTriplet {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {2, 1, 5, 0, 4, 6};
        int[] nums = {5, 4, 3, 2, 1};
        boolean triplet = increasingTriplet(nums);

    }

    private static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= min) {
                min = num;
                continue;
            }
            if (num < secMin) {
                secMin = num;
                continue;
            }
            if (num > min && num > secMin)
                return true;
        }

        return false;
    }
}
